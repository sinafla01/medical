package com.backend.medical.entity;

import jakarta.persistence.*;
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
    @Column(unique = true)
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
}
