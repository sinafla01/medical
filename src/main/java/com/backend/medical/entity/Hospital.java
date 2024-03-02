package com.backend.medical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Hospital {
    // 병원 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "hospital_id")
    private long id;

    // 병원명
    @Column(nullable = false, length = 45)
    private String hospitalName;

    // 요양기관번호
    @Column(nullable = false, length = 20)
    private String nursingAgency;

    // 대표자명
    @Column(nullable = false, length = 10)
    private String delegateName;
}
