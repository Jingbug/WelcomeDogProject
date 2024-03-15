package com.example.welcomedog_web.controller;

import com.example.welcomedog_core.dto.MemberDTO;
import com.example.welcomedog_core.entity.Member;
import com.example.welcomedog_web.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/join")
    public String join() {
        return "page/join";
    }
    @PostMapping("/members/join")
    public String join(@ModelAttribute MemberDTO.Request request) {
        memberService.join(request);
        return "index";
    }

    @PostMapping("/members/login")
    public String login(@ModelAttribute MemberDTO.Request request) {
        Member login = memberService.login(request);
        if (login == null) {
            return "/index";
        }
        return "/page/main";
    }

    @GetMapping("/members/logout")
    public String logout() {
        return "/index";
    }
}
