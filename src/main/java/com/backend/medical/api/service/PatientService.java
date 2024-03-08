package com.backend.medical.api.service;

import com.backend.medical.api.dto.PatientDto;
import com.backend.medical.api.dto.PatientInfoDto;
import com.backend.medical.api.dto.PatientSaveDto;
import com.backend.medical.api.dto.PatientTermsDto;
import com.backend.medical.common.exception.ExistValidException;
import com.backend.medical.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    // 환자목록 조회
    List<PatientDto> findAll(long hospitalId, int pageNo, int pageSize);

    // 환자정보 1건 조회
    PatientInfoDto findByPatient(long patientId);

    // 이름, 생년월일, 환자코드 조건에 따라 조회
    List<PatientDto> findPatientByTerms(PatientTermsDto termsDto);

    // 환자정보 등록
    Patient save(PatientSaveDto patientDto) throws ExistValidException;

    // 환자정보 수정
    Patient update(PatientDto patientDto);

    // 환자정보 삭제
    void delete(long patientId);
}
