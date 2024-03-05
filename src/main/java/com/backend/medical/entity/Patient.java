package com.backend.medical.entity;

import com.backend.medical.api.dto.PatientDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne(targetEntity = Hospital.class, fetch = FetchType.EAGER)
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

    // 방문정보
    @OneToMany
    @JoinTable(name = "visit",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "visit_id")
    )
    private List<Visit> visits = new ArrayList<Visit>();

    @Builder
    public Patient(String name, String genderCode, String patientUuid, String birthday, String phoneNumber, Hospital hospital) {
        this.name = name;
        this.genderCode = genderCode;
        this.patientUuid = patientUuid;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.hospital = hospital;
    }

    public void update(String name, String birthday, String phoneNumber) {
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }
}
