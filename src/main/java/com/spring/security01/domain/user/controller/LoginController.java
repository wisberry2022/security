package com.spring.security01.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("get login page");
        return "login";
    }

    @PostMapping("/login")
    public void loginSuccess() {
        System.out.println("post login page");
    }
}
