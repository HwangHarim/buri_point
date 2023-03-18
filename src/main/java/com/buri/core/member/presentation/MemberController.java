package com.buri.core.member.presentation;

import com.buri.core.common.Response.Handler.ResponseHandler;
import com.buri.core.common.Response.ResponseDto;
import com.buri.core.common.Response.ResponseMessage;
import com.buri.core.member.application.MemberService;
import com.buri.core.member.model.dto.request.CreateMemberRequest;
import com.buri.core.member.model.dto.response.MemberResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
