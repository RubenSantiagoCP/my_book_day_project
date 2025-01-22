package com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity;

import java.time.LocalDateTime;

import com.app.mydaybook.user.domain.enums.LoginType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "user"
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Size(max = 100)
    private String username;

    @Column
    @Size(max = 100)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column(unique = true, nullable = false)
    @Size(max = 100)
    private String email;

    @Column
    @Size(max = 100)
    private String name;

    @Column
    @Size(max = 100)
    private String surname;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
