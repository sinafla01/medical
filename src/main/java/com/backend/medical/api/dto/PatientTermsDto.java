package com.backend.medical.api.dto;

import com.backend.medical.common.Numbers;
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
    // 현재 페이지
    private int pageNo = Numbers.FIRST_PAGE;
    // 보여줄 사이즈
    private int pageSize = Numbers.PAGE_SIZE;
}
