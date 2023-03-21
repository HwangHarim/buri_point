package com.buri.core.error.dto;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {
    /*
    * todo
    * 오류 Message 추가
    * 약식 :ex> INVALID_INPUT_VALUE("E-CM-001", HttpStatus.BAD_REQUEST, "잘못된 입력입니다.")
    * **/

    INTERNAL_SERVER_ERROR("E-IS-001", HttpStatus.BAD_REQUEST, "Internal Server Error"),
    BLANK_CONTENT_JOIN_ERROR("", HttpStatus.BAD_REQUEST, "회원가입 특정 항목의 정보가 비어있습니다."),
    INVALID_EMAIL_ERROR("", HttpStatus.BAD_REQUEST, "잘못된 이메일 정보입니다."),
    INVALID_PHONE_NUMBER_ERROR("", HttpStatus.BAD_REQUEST, "잘못된 핸드폰 번호입니다"),
    INVALID_PIN_NUMBER_ERROR("", HttpStatus.BAD_REQUEST, "잘못된 핀번호 입니다"),
    DUPLICATE_EMAIL_ERROR("", HttpStatus.BAD_REQUEST, "중복된 이메일 입니다.");

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
