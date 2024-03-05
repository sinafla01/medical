package com.backend.medical.api.controller;

import com.backend.medical.api.dto.VisitDto;
import com.backend.medical.api.service.VisitService;
import com.backend.medical.common.ResultMsg;
import com.backend.medical.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
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
    @PostMapping("/save")
    public BaseResponse<Void> save(@RequestBody VisitDto visitDto) {
        visitService.save(visitDto);
        return new BaseResponse<>(HttpStatus.OK.value(), ResultMsg.SUCCESS_SAVE);
    }

    @Operation(summary = "방문정보 수정", description = "방문한 환자정보를 수정한다.")
    @PutMapping("/update")
    public BaseResponse<Void> update(@RequestBody VisitDto visitDto) {
        visitService.update(visitDto);
        return new BaseResponse<>(HttpStatus.OK.value(), ResultMsg.SUCCESS_UPDATE);
    }

    @Operation(summary = "방문정보 삭제", description = "환자의 방문정보를 삭제한다.")
    @PostMapping("/delete/{visitId}")
    public BaseResponse<Void> delete(@PathVariable long visitId) {
        visitService.delete(visitId);
        return new BaseResponse<>(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETE);
    }
}
