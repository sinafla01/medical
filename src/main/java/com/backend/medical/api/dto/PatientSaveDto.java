package com.backend.medical.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientSaveDto {
    private long hospitalId; // 병원 ID
    @NotNull
    private String name; // 환자명
    @NotNull
    private String gender; // 성별
    private String birthday; // 생년월일
    private String phoneNumber; // 휴대폰 전화번호

    @Override
    public String toString() {
        return "PatientSaveDto{" +
                "hospitalId=" + hospitalId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
