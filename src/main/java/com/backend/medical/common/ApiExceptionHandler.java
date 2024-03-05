package com.backend.medical.common;

import com.backend.medical.common.exception.ExistValidException;
import com.backend.medical.common.exception.NotFoundValidException;
import com.backend.medical.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler extends RuntimeException {

    @ExceptionHandler
    public BaseResponse<Void> handlerExistValidException(ExistValidException e) {
        log.error("[handlerCustomException] {} : {}", e.getHttpStatus().name(), e.getMessage());
        return new BaseResponse<>(e.getHttpStatus().value(), e.getMessage());
    }

    @ExceptionHandler
    public BaseResponse<Void> illegalArgumentException(IllegalArgumentException e) {
        log.error("[illegalArgumentException] : {}", e.getMessage());
        return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler
    public BaseResponse<Void> notFoundValidException(NotFoundValidException e) {
        log.error("[notFoundValidException] : {}", e.getMessage());
        return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
