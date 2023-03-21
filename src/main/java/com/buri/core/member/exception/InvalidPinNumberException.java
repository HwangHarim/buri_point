package com.buri.core.member.exception;

import com.buri.core.error.dto.ErrorMessage;
import com.buri.core.error.exception.BusinessException;

public class InvalidPinNumberException extends BusinessException {
    public InvalidPinNumberException() {
        super(ErrorMessage.INVALID_PIN_NUMBER_ERROR);
    }
}
