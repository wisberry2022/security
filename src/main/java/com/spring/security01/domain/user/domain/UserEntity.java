package com.spring.security01.domain.user.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {
    @Id
    private String id;
    private String password;

    public UserVo getEntity() {
        return UserVo.builder().id(id).password(password).build();
    }

}
