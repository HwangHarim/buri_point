package com.buri.core.member.presentation;

import com.buri.core.common.response.ResponseDto;
import com.buri.core.common.response.ResponseMessage;
import com.buri.core.member.application.MemberService;
import com.buri.core.member.dto.request.CreateMemberRequest;
import com.buri.core.member.dto.request.UpdateMemberRequest;
import com.buri.core.member.dto.response.MemberResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/mvp1/member")
public class MemberController {
    private final MemberService memberService;


    @PostMapping
    public ResponseEntity<ResponseDto<MemberResponse>> joinMember(@Valid @RequestBody CreateMemberRequest request) {
        var response = memberService.joinMember(request);

        return ResponseDto.of(ResponseMessage.CREATE_SUCCESS, response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<MemberResponse>> searchMember(@PathVariable Long id) {
        var response = memberService.searchMember(id).toResponseDto();

        return ResponseDto.of(ResponseMessage.OK, response);
    }

    @PatchMapping("/withdraw/{id}")
    public ResponseEntity<ResponseDto<Void>> withdrawMember(@PathVariable Long id) {
        memberService.withdrawMember(id);

        return ResponseDto.noContent(ResponseMessage.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto<MemberResponse>> updateMember(@PathVariable Long id, @Valid @RequestBody UpdateMemberRequest request) {
        var response = memberService.updateMember(id, request);

        return ResponseDto.of(ResponseMessage.OK, response);
    }
}
