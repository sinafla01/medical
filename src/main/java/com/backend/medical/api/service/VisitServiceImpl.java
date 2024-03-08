package com.backend.medical.api.service;

import com.backend.medical.api.dto.VisitDto;
import com.backend.medical.api.repository.HospitalRepository;
import com.backend.medical.api.repository.PatientRepository;
import com.backend.medical.api.repository.VisitRepository;
import com.backend.medical.common.ResultMsg;
import com.backend.medical.entity.Hospital;
import com.backend.medical.entity.Patient;
import com.backend.medical.entity.Visit;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {
    private final HospitalRepository hospitalRepository;
    private final PatientRepository patientRepository;
    private final VisitRepository visitRepository;

    // 방문 등록
    @Override
    @Transactional
    public Visit save(VisitDto visitDto) {
        log.info("[{}] : save()", this.getClass().getName());
        // 병원정보 조회
        Hospital hospital = hospitalRepository.findById(visitDto.getHospitalId())
                .orElseThrow(() -> new IllegalArgumentException(ResultMsg.NOT_HOSPITAL));
        // 환자정보 조회
        Patient patient = patientRepository.findById(visitDto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException(ResultMsg.NOT_PATIENT));
        LocalDateTime now = LocalDateTime.now();
        // 방문정보 저장
        return visitRepository.save(visitDto.toEntity(hospital, patient, now, now));
    }

    // 방문정보 수정
    @Override
    @Transactional
    public Visit update(VisitDto visitDto) {
        log.info("[{}] : update()", this.getClass().getName());
        // 방문정보 조회
        Visit visit = visitRepository.findById(visitDto.getVisitId())
                .orElseThrow(() -> new IllegalArgumentException(ResultMsg.NOT_VISIT));
        visit.update(visitDto.getVisitCode(), LocalDateTime.now());
        // 방문정보 수정
        return visitRepository.save(visit);
    }

    // 방문정보 삭제
    @Override
    @Transactional
    public void delete(long visitId) {
        log.info("[{}] : delete()", this.getClass().getName());
        // 방문정보 조회
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new IllegalArgumentException(ResultMsg.NOT_VISIT));
        // 방문정보 삭제
        visitRepository.deleteById(visit.getId());
    }
}
