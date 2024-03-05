package com.backend.medical.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Visit {
    // 환자방문 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id", unique = true)
    private long id;

    // 병원 ID
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    // 환자 ID
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // 접수 일시
    @Column(name = "receipt_dt", nullable = false)
    private LocalDateTime receiptDt;

    // 생성 일시
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // 방문상태
    @NotNull
    @Column(name = "visit_code", length = 10, nullable = false)
    private String visitCode;

    @Builder
    public Visit(Hospital hospital, Patient patient, String visitCode, LocalDateTime receiptDt, LocalDateTime createdAt) {
        this.hospital = hospital;
        this.patient = patient;
        this.visitCode = visitCode;
        this.receiptDt = receiptDt;
        this.createdAt = createdAt;
    }

    public void update(String visitCode, LocalDateTime receiptDt) {
        this.visitCode = visitCode;
        this.receiptDt = receiptDt;
    }
}
