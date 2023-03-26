package com.spring.security01.domain.root.dept.controller;

import com.spring.security01.global.auth.common.getUserSession;
import com.spring.security01.global.core.auth.getUserSessionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DeptController {


    @GetMapping("/list")
    public String list(HttpServletRequest req, Model model) {
//        getUserSessionInfo userAuth = new getUserSession();
//        if(userAuth.getSessionId() == null) {
//            HttpSession session =  req.getSession();
//
//            session.setAttribute("sessionId", userAuth.getSessionId());
//            session.setAttribute("userId", userAuth.getUsername());
//            session.setAttribute("remoteIp", userAuth.getRemoteAddress());
//        }


        return "dept/list";
    }
}
