package com.backend.medical.api.service;

import com.backend.medical.api.dto.PatientInfoDto;
import com.backend.medical.api.dto.PatientSaveDto;
import com.backend.medical.api.dto.PatientTermsDto;
import com.backend.medical.api.repository.HospitalRepository;
import com.backend.medical.api.repository.PatientRepository;
import com.backend.medical.api.dto.PatientDto;
import com.backend.medical.common.ResultMsg;
import com.backend.medical.common.Util;
import com.backend.medical.common.exception.ExistValidException;
import com.backend.medical.common.exception.NotFoundValidException;
import com.backend.medical.entity.Hospital;
import com.backend.medical.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    // 현재 병원정보를 가지고 올 방법이 없음으로 1L로 하드코딩
    private final long HOSPITAL_ID = 1L;

    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;

    // 환자목록 조회
    @Override
    @Transactional
    public List<PatientDto> findAll(int pageNo, int pageSize) {
        log.info("[{}]: findAll()", this.getClass().getName());
        // 환자목록 조회
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Slice<Patient> patients = patientRepository.findSliceByHospitalId(HOSPITAL_ID, pageable);

        if (patients.isEmpty()) {
            // 환자정보가 없는 경우 예외처리
            throw new NotFoundValidException(HttpStatus.NOT_FOUND, ResultMsg.NOT_FOUND);
        } else {
            // 환자정보가 있는 경우
            return patients.stream().map(PatientDto::new).toList();
        }
    }

    // 환자정보 1건 조회
    @Override
    @Transactional
    public PatientInfoDto findByPatient(long patientId) {
        log.info("[{}]: findByPatient()", this.getClass().getName());
        // 환자정보 조회
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException(ResultMsg.NOT_PATIENT));
        return new PatientInfoDto(patient, patient.getVisits());
    }

    // 이름, 생년월일, 환자코드 조건에 따라 조회
    @Override
    @Transactional
    public List<PatientDto> findPatientByTerms(PatientTermsDto termsDto) {
        log.info("[{}]: findPatientByTerms", this.getClass().getName());
        // 유효성 검사
        if (!Util.isBirthdayValidation(termsDto.getBirthday())) {
            throw new IllegalStateException(ResultMsg.NOT_VALID_PATTERN + "(예: 2000-01-01)");
        }
        // 환자 목록 조회
        Pageable pageable = PageRequest.of(termsDto.getPageNo() - 1, termsDto.getPageSize());
        List<PatientDto> patientList = patientRepository.findPatientByTerms(termsDto.getName(), termsDto.getBirthday(), termsDto.getPatientCode(), pageable);

        if (patientList.isEmpty()) {
            // 환자정보가 없는 경우 예외처리
            throw new NotFoundValidException(HttpStatus.NOT_FOUND, ResultMsg.NOT_FOUND);
        } else {
            // 환자정보가 있는 경우
            return patientList;
        }
    }

    // 환자정보 저장
    @Override
    @Transactional
    public Patient save(PatientSaveDto patientDto) throws ExistValidException {
        log.info("[{}]: save()", this.getClass().getName());
        // 유효성 검사
        validation(patientDto.getBirthday(), patientDto.getPhoneNumber());
        String genderCode = Util.getGenderCode(patientDto.getGender());
        // 환자정보 조회
        Optional<Patient> patient = patientRepository.findByNameAndGenderCode(patientDto.getName(), genderCode);

        if (patient.isPresent()) {
            // 조회된 환자 정보가 있는 경우
            throw new ExistValidException(HttpStatus.OK, ResultMsg.EXIST_PATIENT);
        } else {
            // 조회된 환자 정보가 없는 경우
            // 병원정보 조회
            Hospital hospital = hospitalRepository.findById(HOSPITAL_ID)
                    .orElseThrow(() -> new IllegalArgumentException(ResultMsg.NOT_HOSPITAL));
            return patientRepository.save(
                    Patient.builder()
                            .name(patientDto.getName())
                            .phoneNumber(patientDto.getPhoneNumber())
                            .birthday(patientDto.getBirthday())
                            .patientUuid(createCode())
                            .genderCode(genderCode)
                            .hospital(hospital)
                            .build()
            );
        }
    }

    // 환자정보 수정
    @Override
    public Patient update(PatientDto patientDto) {
        log.info("[{}]: update()", this.getClass().getName());
        // 유효성 검사
        validation(patientDto.getBirthday(), patientDto.getPhoneNumber());
        // 환자정보 조회
        Patient patient = patientRepository.findById(patientDto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException(ResultMsg.NOT_PATIENT));
        patient.update(patientDto.getName(), patientDto.getBirthday(), patientDto.getPhoneNumber()); // 수정
        return patientRepository.save(patient);
    }

    // 환자정보 삭제
    @Override
    public void delete(long patientId) {
        log.info("[{}]: delete()", this.getClass().getName());
        // 환자정보 조회
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException(ResultMsg.NOT_PATIENT));
        patientRepository.deleteById(patient.getId());
    }

    // 환자등록번호 생성
    // 환자등록번호 규칙 : 연도 + (병원의 환자 수 + 1) - 예) 2023000001
    private String createCode() {
        log.info("[{}]: createCode()", this.getClass().getName());
        int year = LocalDate.now().getYear();
        int patientCount = patientRepository.countByHospitalId(HOSPITAL_ID);
        return year + String.format("%06d", patientCount + 1);
    }

    // 생년월일, 휴대폰번호 패턴검사
    private void validation(String birthday, String phoneNumber) {
        // 생년월일 패턴 검사 (에: 2000-01-01)
        if (birthday != null && !Util.isBirthdayValidation(birthday)) {
            throw new IllegalArgumentException(ResultMsg.NOT_VALID_PATTERN + "(예: 2000-01-01)");
        }
        // 휴대폰 패턴 검사 (예: 010-1111-1111)
        if (phoneNumber != null && !Util.isPhoneValidation(phoneNumber)) {
            throw new IllegalArgumentException(ResultMsg.NOT_VALID_PATTERN + "(예: 010-1111-1111)");
        }
    }
}
