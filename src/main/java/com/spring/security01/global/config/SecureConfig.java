package com.spring.security01.global.config;

import com.spring.security01.global.auth.common.getUserSession;
import com.spring.security01.global.core.auth.getUserSessionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecureConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
                .usernameParameter("id")
                .passwordParameter("pwd")
                .successHandler(((request, response, authentication) -> {
                    getUserSessionInfo userAuth = new getUserSession(SecurityContextHolder.getContext());

//                    System.out.println("userAuth의 sessionId " + userAuth.getSessionId());
                    HttpSession session = request.getSession();
                    if(userAuth.getSessionId() != null) {

                        session.setAttribute("sessionId", userAuth.getSessionId());
                        session.setAttribute("userId", userAuth.getUsername());
                        session.setAttribute("remoteIp", userAuth.getRemoteAddress());
                        response.sendRedirect("/");
                    }
                }))
                .and()
                .logout((logout) -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );

        http.csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
