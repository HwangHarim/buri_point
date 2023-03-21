package com.buri.core.member.exception;

import com.buri.core.error.dto.ErrorMessage;
import com.buri.core.error.exception.BusinessException;

public class InvalidEmailException extends BusinessException {
    public InvalidEmailException() {
        super(ErrorMessage.INVALID_EMAIL_ERROR);
    }
}
