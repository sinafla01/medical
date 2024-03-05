package com.backend.medical.api.dto;

import com.backend.medical.entity.Patient;
import com.backend.medical.entity.Visit;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PatientInfoDto {
    private Patient patient;
    private List<Visit> visits;

    public PatientInfoDto(Patient patient, List<Visit> visits) {
        this.patient = patient;
        this.visits = visits;
    }
}
