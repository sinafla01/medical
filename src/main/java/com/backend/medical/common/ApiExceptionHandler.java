package com.backend.medical.common;

import com.backend.medical.common.exception.ExistValidException;
import com.backend.medical.common.exception.NotFoundValidException;
import com.backend.medical.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler extends RuntimeException {

    @ExceptionHandler
    protected BaseResponse<Void> handlerExistValidException(ExistValidException e) {
        log.error("[handlerCustomException] {} : {}", e.getHttpStatus().name(), e.getMessage());
        return new BaseResponse<>(e.getHttpStatus().value(), e.getMessage());
    }

    @ExceptionHandler
    protected BaseResponse<Void> illegalArgumentException(IllegalArgumentException e) {
        log.error("[illegalArgumentException]: {}", e.getMessage());
        return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler
    protected BaseResponse<Void> notFoundValidException(NotFoundValidException e) {
        log.error("[notFoundValidException]: {}", e.getMessage());
        return new BaseResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler
    protected BaseResponse<Void> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("[methodArgumentNotValidException]: {}", e.getMessage());
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler
    protected BaseResponse<Void> defaultException(Exception e) {
        log.error("[defaultException]: {}", e.getMessage());
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler
    protected  BaseResponse<Void> illegalStateException(IllegalStateException e) {
        log.error("[IllegalStateException]: {}", e.getMessage());
        return new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
