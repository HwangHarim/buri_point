package com.buri.core.member.exception;

import com.buri.core.error.dto.ErrorMessage;
import com.buri.core.error.exception.BusinessException;

public class InvalidPhoneNumberException extends BusinessException {
    public InvalidPhoneNumberException() {
        super(ErrorMessage.INVALID_PHONE_NUMBER_ERROR);
    }
}
