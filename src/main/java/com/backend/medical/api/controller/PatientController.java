package com.backend.medical.api.controller;

import com.backend.medical.api.dto.PatientInfoDto;
import com.backend.medical.api.service.PatientService;
import com.backend.medical.api.dto.PatientDto;
import com.backend.medical.common.ResultMsg;
import com.backend.medical.common.exception.ExistValidException;
import com.backend.medical.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
@Tag(name = "Patient", description = "환자 등록 및 수정, 조회")
public class PatientController {
    private final PatientService patientService;

    @Operation(summary = "환자목록 조회", description = "환자 목록을 조회한다.")
    @GetMapping("/all")
    public BaseResponse<List<PatientDto>> findAll() {
        List<PatientDto> patients = patientService.findAll();
        return new BaseResponse<>(HttpStatus.OK.value(), patients,ResultMsg.SUCCESS_FIND_ALL);
    }

    @Operation(summary = "환자정보 1건 조회", description = "환자 정보 1건을 조회한다.")
    @GetMapping("/{patientId}")
    public BaseResponse<PatientInfoDto> findByPatient(@PathVariable long patientId) {
        PatientInfoDto patientInfoDto = patientService.findByPatient(patientId);
        return new BaseResponse<>(HttpStatus.OK.value(), patientInfoDto, ResultMsg.SUCCESS_FIND);
    }

    @Operation(summary = "환자정보 등록", description = "회원정보를 등록한다.")
    @PostMapping("/save")
    public BaseResponse<Void> save(@RequestBody PatientDto patientDto) throws ExistValidException {
        patientService.save(patientDto);
        return new BaseResponse<>(HttpStatus.OK.value(), ResultMsg.SUCCESS_SAVE);
    }

    @Operation(summary = "환자정보 수정", description = "환자정보를 수정한다.")
    @PutMapping("/update")
    public BaseResponse<Void> update(@RequestBody PatientDto patientDto) {
        patientService.update(patientDto);
        return new BaseResponse<>(HttpStatus.OK.value(), ResultMsg.SUCCESS_UPDATE);
    }

    @Operation(summary = "환자정보 삭제", description = "환자정보를 삭제한다.")
    @PostMapping("/delete/{patientId}")
    public BaseResponse<Void> delete(@PathVariable long patientId) {
        patientService.delete(patientId);
        return new BaseResponse<>(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETE);
    }
}
