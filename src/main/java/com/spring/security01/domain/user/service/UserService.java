package com.spring.security01.domain.user.service;

import com.spring.security01.domain.user.domain.UserDetail;
import com.spring.security01.domain.user.domain.UserEntity;
import com.spring.security01.domain.user.domain.UserVo;
import com.spring.security01.domain.user.repository.UserRepo;
import com.spring.security01.global.auth.encrypt.PwdEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepo repo;
    private final PwdEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//        UserVo user = repo.getReferenceById(id).getEntity();
        UserVo user = UserVo.builder().id("user1").password(encoder.encodePassword("1234")).build();

        if (id.equals(user.getId())) {
            UserDetails userDetail = new UserDetail(user);
            System.out.println("UserService " + userDetail);
            return userDetail;
        }
        return null;
    }
}