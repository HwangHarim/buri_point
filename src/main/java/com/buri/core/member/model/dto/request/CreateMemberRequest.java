package com.buri.core.member.model.dto.request;

import com.buri.core.member.domain.Member;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^01(?:0|1|[6-9])-?(\\d{3}|\\d{4})-?(\\d{4})$")
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @Size(min=4, max=4)
    private String pin;


    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .password(this.password)
                .pin(this.pin)
                .build();
    }
}
