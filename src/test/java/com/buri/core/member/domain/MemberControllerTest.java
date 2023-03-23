package com.buri.core.member.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.JsonFieldType.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class MemberControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void member_get() throws Exception {
        mockMvc.perform(
                        get("/api/mvp1/member/{id}", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(
                        document("member-get",
                                pathParameters(
                                        parameterWithName("id").description("Member id")
                                ),
                                responseFields(
                                        fieldWithPath("message").description("message"),
                                        fieldWithPath("serverDateTime").description("serverDateTime"),
                                        fieldWithPath("data").type(OBJECT).description("회원 데이터"),
                                        fieldWithPath("data.id").type(NUMBER).description("회원 번호"),
                                        fieldWithPath("data.name").type(STRING).description("이름"),
                                        fieldWithPath("data.phoneNumber").type(STRING).description("전화번호"),
                                        fieldWithPath("data.email").type(STRING).description("이메일"),
                                        fieldWithPath("data.password").type(STRING).description("비밀번호"),
                                        fieldWithPath("data.pin").type(STRING).description("핀 번호"),
                                        fieldWithPath("data.point").type(NUMBER).description("포인트")
                                )

                        )
                );
    }
}
