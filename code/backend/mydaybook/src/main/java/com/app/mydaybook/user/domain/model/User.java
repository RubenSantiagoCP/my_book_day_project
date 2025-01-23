package com.app.mydaybook.user.domain.model;

import java.time.LocalDateTime;

import com.app.mydaybook.user.domain.enums.LoginType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    
    private Long id;
    private String username;
    private String password;
    private LoginType loginType;
    private String email;
    private String name;
    private String surname;
    private LocalDateTime createdAt;
}
