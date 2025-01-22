package com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    
}
