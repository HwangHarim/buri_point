package com.buri.core.member.domain.vo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Getter;

import java.util.regex.Pattern;

@Embeddable
@Getter
public class PinNumber {
    @Transient
    private static final String PIN_REGEX = "^\\d{4}$";

    @Transient
    public final static String NO_PIN = "NO_PIN";

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
        return NO_PIN;
    }
}
