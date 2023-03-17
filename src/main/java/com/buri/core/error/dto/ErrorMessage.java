package com.buri.core.error.dto;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {
    /*
    * todo
    * 오류 Message 추가
    * 약식 :ex> INVALID_INPUT_VALUE("E-CM-001", HttpStatus.BAD_REQUEST, "잘못된 입력입니다.")
    * **/

    INTERNAL_SERVER_ERROR("E-IS-001", HttpStatus.BAD_REQUEST, "Internal Server Error");

    private final String code;
    private final HttpStatus status;
    private final String message;

    ErrorMessage(String code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
