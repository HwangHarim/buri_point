package com.buri.core.member.presentation;

import com.buri.core.common.Response.Handler.ResponseHandler;
import com.buri.core.common.Response.ResponseDto;
import com.buri.core.common.Response.ResponseMessage;
import com.buri.core.member.application.MemberService;
import com.buri.core.member.dto.request.CreateMemberRequest;
import com.buri.core.member.dto.request.UpdateMemberRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/mvp1/member")
public class MemberController {
    private final MemberService memberService;

    private final ResponseHandler responseHandler;

    @PostMapping
    public ResponseEntity<ResponseDto> joinMember(@Valid @RequestBody CreateMemberRequest request) {
        var response = memberService.joinMember(request);

        return responseHandler.toResponseEntity(ResponseMessage.CREATE_SUCCESS, response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> searchMember(@PathVariable Long id) {
        var response = memberService.searchMember(id);

        return responseHandler.toResponseEntity(ResponseMessage.OK, response);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> withdrawMember(@PathVariable Long id) {
        Long withdrawMemberId = memberService.withdrawMember(id);

        return responseHandler.toResponseEntity(ResponseMessage.OK, "회원탈퇴 완료. 반환값 없음");
        // ResponseDto 전역 클래스 수정 후 수정 예정
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> updateMember(@PathVariable Long id, @Valid @RequestBody UpdateMemberRequest request) {
        var updataMember = memberService.updateMember(id, request);

        return responseHandler.toResponseEntity(ResponseMessage.OK, updataMember);
    }
}
