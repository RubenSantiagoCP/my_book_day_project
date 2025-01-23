package com.app.mydaybook.user.infrastructure.adapters.input.rest.data.response;

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

public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String createdAt;
    private LoginType loginType;
}
