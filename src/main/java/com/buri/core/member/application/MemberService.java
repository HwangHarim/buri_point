package com.buri.core.member.application;

import com.buri.core.member.infrastructure.MemberRepository;
import com.buri.core.member.model.dto.request.CreateMemberRequest;
import com.buri.core.member.model.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse joinMember(CreateMemberRequest request) {
        var result = memberRepository.save(request.toEntity());

        return result.toResponseDto();
    }

    @Transactional(readOnly = true)
    public MemberResponse findByIdMember(Long id) {
        return memberRepository.findById(id).get().toResponseDto();
    }
}
