package com.backend.medical.common.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BaseResponse<T> {
    private int status;

    private T data;

    private String message;

    public BaseResponse(T data) {
        this.status = HttpStatus.OK.value();
        this.data = data;
    }

    public BaseResponse(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
