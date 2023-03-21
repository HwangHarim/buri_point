package com.buri.core.member.application;

import com.buri.core.member.domain.Member;
import com.buri.core.member.domain.vo.Email;
import com.buri.core.member.domain.vo.PhoneNumber;
import com.buri.core.member.domain.vo.PinNumber;
import com.buri.core.member.dto.request.UpdateMemberRequest;
import com.buri.core.member.exception.BlankContentJoinException;
import com.buri.core.member.exception.InvalidEmailException;
import com.buri.core.member.exception.InvalidPhoneNumberException;
import com.buri.core.member.exception.InvalidPinNumberException;
import com.buri.core.member.infrastructure.MemberRepository;
import com.buri.core.member.dto.request.CreateMemberRequest;
import com.buri.core.member.dto.response.MemberResponse;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse joinMember(CreateMemberRequest request) {
        var member = request.toEntity();
        validateCreateRequest(member);
        duplicateCheckEmail(member.getEmail());
        var result = memberRepository.save(member);

        return result.toResponseDto();
    }

    private void validateCreateRequest(Member member) {
        if(member.getName().isBlank() || member.getPassword().isBlank()) {
            throw new BlankContentJoinException();
        }
        if(member.getEmail().getEmail().equals(Email.NO_EMAIL)) {
            throw new InvalidEmailException();
        }
        if(member.getPhoneNumber().getPhoneNumber().equals(PhoneNumber.NO_PHONE)) {
            throw new InvalidPhoneNumberException();
        }
        if(member.getPin().getPinNumber().equals(PinNumber.NO_PIN)) {
            throw new InvalidPinNumberException();
        }
    }

    @Transactional(readOnly = true)
    protected void duplicateCheckEmail(Email email) {
        var account = memberRepository.findByEmail(email);
        if(account.isPresent()) {
            throw new DuplicateRequestException();
        }
    }

    @Transactional(readOnly = true)
    public Member searchMember(Long id) {
        var searchMember = memberRepository.findById(id).get();

        return searchMember;
    }

    @Transactional
    public MemberResponse withdrawMember(Long id) {
        var withdrawMember = searchMember(id);
        withdrawMember.withdrawMember();
        memberRepository.save(withdrawMember);

        return withdrawMember.toResponseDto();
    }

    @Transactional
    public MemberResponse updateMember(Long id, UpdateMemberRequest request) {
        var updateMember = searchMember(id);
        updateMember.updateMember(request);

        return updateMember.toResponseDto();
    }
}
