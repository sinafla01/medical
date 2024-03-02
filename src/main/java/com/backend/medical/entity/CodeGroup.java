package com.backend.medical.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CodeGroup {
    // 코드 그룹
    @Id
    @Column(name = "code_group", length = 10, nullable = false, unique = true)
    private String codeGroup;

    // 코드그룹명
    @Column(name = "group_name", length = 10, nullable = false)
    private String groupName;

    // 설명
    @Column(name = "explanation", length = 10, nullable = false)
    private String explanation;
}
