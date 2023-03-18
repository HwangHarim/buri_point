package com.buri.core.member.domain;

import com.buri.core.common.domain.BaseTime;
import com.buri.core.member.model.dto.response.MemberResponse;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(name="member_index", columnList = "id")
})
public class Member extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String pin;

    @Column
    private Long point;

    @Builder
    public Member(String name, String phoneNumber, String email
            , String password, String pin) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.pin = pin;
        this.point = 3000L;
    }

    public MemberResponse toResponseDto() {
        return MemberResponse.builder()
                .id(this.id)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .email(email)
                .password(this.password)
                .pin(this.pin)
                .point(this.point)
                .build();
    }
}
