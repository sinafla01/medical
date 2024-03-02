package com.backend.medical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Code {
    // 코드
    @Id
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    // 코드그룹
    @ManyToOne
    @JoinColumn(name = "code_group")
    private CodeGroup codeGroup;

    // 코드명
    @Column(name = "code_name", length = 10, nullable = false)
    private String codeName;
}
