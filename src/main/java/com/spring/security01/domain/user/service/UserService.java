package com.spring.security01.domain.user.service;

import com.spring.security01.domain.user.domain.UserDetail;

import com.spring.security01.domain.user.domain.UserEntity;
import com.spring.security01.domain.user.domain.UserVo;
import com.spring.security01.domain.user.repository.UserRepo;
import com.spring.security01.global.auth.encrypt.PwdEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepo repo;
    private final PwdEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<UserEntity> Temp = repo.findById(id);
        UserVo user = Temp.get().getEntity();
        user.setPassword(encoder.encodePassword(user.getPassword()));
        if (id.equals(user.getId())) {
            UserDetails userDetail = new UserDetail(user);
            return userDetail;
        }
        return null;
    }
}