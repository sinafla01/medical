package com.backend.medical.api.repository;

import com.backend.medical.api.dto.PatientDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientCustom {
    List<PatientDto> findPatientByTerms(String name, String birthday, String patientCode, Pageable pageable);
}
