package com.spring.security01.domain.user.controller;

import com.spring.security01.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService service;

    @GetMapping("/login")
    public String login() {
        System.out.println("get login page");
        return "login";
    }
//    @PostMapping("/login")
//    public void loginProcess(HttpServletRequest req, HttpServletResponse resp) {
//        String id = req.getParameter("id");
//        String pwd = req.getParameter("pwd");
//
//        System.out.println("login post");
//        service.loadUserByUsername(id);
//
//
//
//
//    }
}
