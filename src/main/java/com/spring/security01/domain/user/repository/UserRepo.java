package com.spring.security01.domain.user.repository;

import com.spring.security01.domain.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {
}
