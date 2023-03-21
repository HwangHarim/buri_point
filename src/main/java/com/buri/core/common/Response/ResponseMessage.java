package com.buri.core.common.Response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseMessage {

    CREATE_SUCCESS(HttpStatus.CREATED, "성공"),
    OK(HttpStatus.OK, "성공"),
    NO_CONTENT(HttpStatus.NO_CONTENT, "성공");
    private final HttpStatus status;
    private final String message;

    ResponseMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}