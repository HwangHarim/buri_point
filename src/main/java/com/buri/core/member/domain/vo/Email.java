package com.buri.core.member.domain.vo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Getter;

import java.util.regex.Pattern;

@Embeddable
@Getter
public class Email {
    @Transient
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Transient
    public final static String NO_EMAIL = "NO_EMAIL";

    private String email;

    protected Email() {
    }

    public Email(String email) {
        this.email = validate(email);
    }

    private String validate(String email) {
        if (Pattern.matches(EMAIL_REGEX, email)) {
            return email;
        }
        return NO_EMAIL;
    }
}
