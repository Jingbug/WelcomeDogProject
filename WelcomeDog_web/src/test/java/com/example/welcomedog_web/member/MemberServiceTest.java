package com.example.welcomedog_web.member;

import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_web.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("Join Success")
    void join() {
        // given
        MemberDTO.Request request = new MemberDTO.Request();
        request.setMemberId("ysm0419");
        request.setPassword("1234");
        request.setMemberName("SM");
        request.setTel("010-1111-1111");
        request.setEmail("ysm0419@naver.com");

        // when
        memberService.join(request);
        boolean result = memberService.findMember("ysm0419");

        // then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Login Success")
    void login() {
        // given
        MemberDTO.Request request = new MemberDTO.Request();
        request.setMemberId("rjy1209");
        request.setPassword("1234");

        // when
        Member login = memberService.login(request);

        // then
        Assertions.assertThat(login.getMemberId()).isEqualTo("rjy1209");
    }
}
