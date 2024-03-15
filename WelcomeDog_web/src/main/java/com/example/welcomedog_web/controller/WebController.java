package com.example.welcomedog_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/main")
    public String main() {
        return "page/main";
    }
}
