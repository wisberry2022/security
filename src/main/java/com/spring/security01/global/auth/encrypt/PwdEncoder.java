package com.spring.security01.global.auth.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PwdEncoder {

    public String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
