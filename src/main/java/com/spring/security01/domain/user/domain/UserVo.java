package com.spring.security01.domain.user.domain;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo {
    private String id;
    private String password;
}
