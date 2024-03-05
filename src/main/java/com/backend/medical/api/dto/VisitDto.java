package com.backend.medical.api.dto;

import com.backend.medical.entity.Hospital;
import com.backend.medical.entity.Patient;
import com.backend.medical.entity.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {
    private long visitId; // 환자방문 ID
    private long hospitalId; // 병원 ID
    private long patientId; // 환자 ID
    private LocalDateTime receiptDt; // 접수일시
    private String visitCode; // 방문코드

    public Visit toEntity(Hospital hospital, Patient patient, LocalDateTime receiptDt, LocalDateTime createdAt) {
        return Visit.builder()
                .visitCode(visitCode)
                .patient(patient)
                .hospital(hospital)
                .receiptDt(receiptDt)
                .createdAt(createdAt)
                .build();
    }

    public VisitDto(long hospitalId, long patientId, String visitCode) {
        this.hospitalId = hospitalId;
        this.patientId = patientId;
        this.visitCode = visitCode;
    }

    @Override
    public String toString() {
        return "VisitDto{" +
                "visitId=" + visitId +
                ", hospitalId=" + hospitalId +
                ", patientId=" + patientId +
                ", receiptDt=" + receiptDt +
                ", visitCode='" + visitCode + '\'' +
                '}';
    }
}
