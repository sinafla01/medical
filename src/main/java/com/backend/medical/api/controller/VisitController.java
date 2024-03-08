package com.backend.medical.api.controller;

import com.backend.medical.api.dto.VisitDto;
import com.backend.medical.api.service.VisitService;
import com.backend.medical.common.ResultMsg;
import com.backend.medical.common.response.BaseResponse;
import com.backend.medical.entity.Visit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Visit")
@RestController
@RequestMapping("/api/v1/visit")
@RequiredArgsConstructor
public class VisitController {
    private final VisitService visitService;

    @Operation(summary = "방문환자 등록", description = "방문한 환자를 등록한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "저장) 정상적으로 저장되었습니다. / 실패) 저장에 실패했습니다."),
                    @ApiResponse(responseCode = "404", description = "등록된 병원정보가 없습니다. / 등록된 환자정보가 없습니다.")
            }
    )
    @PostMapping("/save")
    public BaseResponse<Void> save(@RequestBody VisitDto visitDto) {
        Visit visit = visitService.save(visitDto);
        String resultMsg = visit.getId() > 0 ? ResultMsg.SUCCESS_SAVE : ResultMsg.FAIL_SAVE;
        return new BaseResponse<>(HttpStatus.OK.value(), resultMsg);
    }

    @Operation(summary = "방문정보 수정", description = "방문한 환자정보를 수정한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "정상적으로 수정되었습니다."),
                    @ApiResponse(responseCode = "404", description = "등록된 방문정보가 없습니다.")
            }
    )
    @PutMapping("/update")
    public BaseResponse<Void> update(@RequestBody VisitDto visitDto) {
        Visit visit = visitService.update(visitDto);
        String resultMsg = visit.getId() > 0 ? ResultMsg.SUCCESS_UPDATE : ResultMsg.FAIL_UPDATE;
        return new BaseResponse<>(HttpStatus.OK.value(), resultMsg);
    }

    @Operation(summary = "방문정보 삭제", description = "환자의 방문정보를 삭제한다.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "정상적으로 삭제되었습니다."),
                    @ApiResponse(responseCode = "404", description = "등록된 방문정보가 없습니다.")
            }
    )
    @PostMapping("/delete/{visitId}")
    public BaseResponse<Void> delete(@PathVariable long visitId) {
        visitService.delete(visitId);
        return new BaseResponse<>(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETE);
    }
}
