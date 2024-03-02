package com.backend.medical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Patient {
    // 환자 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", unique = true)
    private long id;

    // 병원 ID
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    // 환자명
    @Column(name = "name", length = 45, nullable = false)
    private String name;

    // 환자등록번호
    @Column(name = "patient_uuid", length = 13, nullable = false)
    private String patientUuid;

    // 성별코드
    @Column(name = "gender_code", length = 10, nullable = false)
    private String genderCode;

    // 생년월일
    @Column(name = "birthday", length = 10)
    private String birthday;

    // 휴대폰 전화번호
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}
