package com.buri.core.member.domain.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberState {
        ACTIVE("활성"),
        INACTIVE("비활성");

        private final String description;
}
