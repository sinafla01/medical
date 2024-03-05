package com.backend.medical.api.service;

import com.backend.medical.api.dto.PatientDto;
import com.backend.medical.api.dto.PatientInfoDto;
import com.backend.medical.common.exception.ExistValidException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    // 환자목록 조회
    List<PatientDto> findAll();

    // 환자정보 1건 조회
    PatientInfoDto findByPatient(long patientId);

    // 환자정보 등록
    void save(PatientDto patientDto) throws ExistValidException;

    // 환자정보 수정
    void update(PatientDto patientDto);

    // 환자정보 삭제
    void delete(long patientId);
}
