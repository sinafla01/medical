package com.backend.medical.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExistValidException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public ExistValidException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
