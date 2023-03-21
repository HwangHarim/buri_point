package com.buri.core.member.exception;

import com.buri.core.error.dto.ErrorMessage;
import com.buri.core.error.exception.BusinessException;

public class BlankContentJoinException extends BusinessException {
    public BlankContentJoinException() {
        super(ErrorMessage.BLANK_CONTENT_JOIN_ERROR);
    }
}
