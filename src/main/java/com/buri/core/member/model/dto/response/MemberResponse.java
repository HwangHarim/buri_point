package com.buri.core.member.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private String pin;
    private Long point;

    @Builder
    public MemberResponse (Long id, String name,
                           String phoneNumber, String email,
                           String password, String pin, Long point) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.pin = pin;
        this.point = point;
    }
}
