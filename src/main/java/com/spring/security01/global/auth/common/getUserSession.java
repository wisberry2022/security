package com.spring.security01.global.auth.common;

import com.spring.security01.global.core.auth.getUserSessionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

public class getUserSession implements getUserSessionInfo {


    private SecurityContext context;
    private Authentication userAuth;

    public getUserSession() {
        this.context = SecurityContextHolder.getContext();
        this.userAuth = context.getAuthentication();
        System.out.println("getUserSession 내부 " + context);
        System.out.println("getUserSession 내부 " + userAuth);
    }

    public getUserSession(SecurityContext context) {
        this.context = context;
        userAuth = context.getAuthentication();
        System.out.println("getUserSession 내부 " + context);
        System.out.println("getUserSession 내부 " + userAuth);
    }

    @Override
    public String getUsername() {
        return userAuth.getName();
    }

    @Override
    public String getSessionId() {
        return ((WebAuthenticationDetails)userAuth.getDetails()).getSessionId();
    }

    public String getRemoteAddress() {
        return ((WebAuthenticationDetails)userAuth.getDetails()).getRemoteAddress();
    }

}
