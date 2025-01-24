package com.app.mydaybook.user.infrastructure.adapters.input.rest.data.response;

import java.time.LocalDateTime;

import com.app.mydaybook.user.domain.enums.LoginType;
import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private LoginType loginType;
}
