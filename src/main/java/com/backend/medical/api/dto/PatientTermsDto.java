package com.backend.medical.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientTermsDto {
    // 이름
    private String name;
    // 생년월일
    private String birthday;
    // 환자등록코드
    private String patientCode;
}
