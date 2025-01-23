package com.app.mydaybook.user.infrastructure.adapters.input.rest.data.request;

import com.app.mydaybook.user.domain.enums.LoginType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

public class UserRequest {
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    private String password;

    @NotNull(message = "Login type is required")
    private LoginType loginType;

    @NotBlank(message = "Email is required")
    private String email;

    private String name;
    
    private String surname;
}
