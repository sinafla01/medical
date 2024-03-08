package com.backend.medical.api.controller;

import com.backend.medical.api.dto.PatientInfoDto;
import com.backend.medical.api.dto.PatientSaveDto;
import com.backend.medical.api.dto.PatientTermsDto;
import com.backend.medical.api.service.PatientService;
import com.backend.medical.api.dto.PatientDto;
import com.backend.medical.common.ResultMsg;
import com.backend.medical.common.exception.ExistValidException;
import com.backend.medical.common.response.BaseResponse;
import com.backend.medical.entity.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "정상적으로 목록이 조회되었습니다."),
                    @ApiResponse(responseCode = "404", description = "검색결과가 없습니다.")
            }
    )
    @GetMapping("/all")
    public BaseResponse<List<PatientDto>> findAll(
            @RequestParam(value = "hospitalId") long hospitalId,
            @RequestParam(value = "pageNo") int pageNo,
            @RequestParam(value = "pageSize") int pageSize
    ) {
        List<PatientDto> patients = patientService.findAll(hospitalId, pageNo, pageSize);
        return new BaseResponse<>(HttpStatus.OK.value(), patients, ResultMsg.SUCCESS_FIND_ALL);
    }

    @Operation(summary = "환자정보 1건 조회", description = "환자 정보 1건을 조회한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "정상적으로 정보가 조회되었습니다."),
                    @ApiResponse(responseCode = "404", description = "등록된 환자정보가 없습니다.")
            }
    )
    @GetMapping("/{patientId}")
    public BaseResponse<PatientInfoDto> findByPatient(@PathVariable long patientId) {
        PatientInfoDto patientInfoDto = patientService.findByPatient(patientId);
        return new BaseResponse<>(HttpStatus.OK.value(), patientInfoDto, ResultMsg.SUCCESS_FIND);
    }

    @Operation(summary = "검색 조건에 따라 환자목록 조회", description = "환자이름, 생년월일, 환자등록번호로 검색한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "정상적으로 목록이 조회되었습니다."),
                    @ApiResponse(responseCode = "400", description = "형식을 확인해주세요. (예: 2000-01-01)"),
                    @ApiResponse(responseCode = "404", description = "검색결과가 없습니다.")
            }
    )
    @GetMapping("/find")
    public BaseResponse<List<PatientDto>> findPatientByTerms(@Valid PatientTermsDto termsDto) {
        List<PatientDto> patients = patientService.findPatientByTerms(termsDto);
        return new BaseResponse<>(HttpStatus.OK.value(), patients, ResultMsg.SUCCESS_FIND_ALL);
    }

    @Operation(summary = "환자정보 등록", description = "회원정보를 등록한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "기존환자) 이미 등록된 환자입니다. / 정상저장) 정상적으로 저장되었습니다."),
                    @ApiResponse(responseCode = "400", description = "형식을 확인해주세요. (예: 2000-01-01) / 형식을 확인해주세요. (예: 010-1111-1111)"),
                    @ApiResponse(responseCode = "404", description = "등록된 환자정보가 없습니다.")
            }
    )
    @PostMapping("/save")
    public BaseResponse<Void> save(@RequestBody @Valid PatientSaveDto patientDto) throws ExistValidException {
        Patient patient = patientService.save(patientDto);
        String resultMsg = patient.getId() > 0 ? ResultMsg.SUCCESS_SAVE : ResultMsg.FAIL_SAVE;
        return new BaseResponse<>(HttpStatus.OK.value(), resultMsg);
    }

    @Operation(summary = "환자정보 수정", description = "환자정보를 수정한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "정상적으로 수정되었습니다."),
                    @ApiResponse(responseCode = "400", description = "형식을 확인해주세요. (예: 2000-01-01) / 형식을 확인해주세요. (예: 010-1111-1111)"),
                    @ApiResponse(responseCode = "404", description = "등록된 환자정보가 없습니다.")
            }
    )
    @PutMapping("/update")
    public BaseResponse<Void> update(@RequestBody PatientDto patientDto) {
        Patient patient = patientService.update(patientDto);
        String resultMsg = patient.getId() > 0 ? ResultMsg.SUCCESS_UPDATE : ResultMsg.FAIL_UPDATE;
        return new BaseResponse<>(HttpStatus.OK.value(), resultMsg);
    }

    @Operation(summary = "환자정보 삭제", description = "환자정보를 삭제한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "정상적으로 삭제되었습니다."),
                    @ApiResponse(responseCode = "404", description = "등록된 환자정보가 없습니다.")
            }
    )
    @PostMapping("/delete/{patientId}")
    public BaseResponse<Void> delete(@PathVariable long patientId) {
        patientService.delete(patientId);
        return new BaseResponse<>(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETE);
    }
}
