package com.buri.core.member.domain.vo;

import com.buri.core.member.exception.InvalidPinNumberException;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Getter;

import java.util.regex.Pattern;

@Embeddable
@Getter
public class PinNumber {
    @Transient
    private static final String PIN_REGEX = "^\\d{4}$";

    private String pinNumber;

    protected PinNumber() {
    }

    public PinNumber(String pinNumber) {
        this.pinNumber = validate(pinNumber);
    }

    private String validate(String pinNumber) {
        if (Pattern.matches(PIN_REGEX, pinNumber)) {
            return pinNumber;
        }
        throw new InvalidPinNumberException();
    }
}
