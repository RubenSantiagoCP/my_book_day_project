package com.app.mydaybook.user.application.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.app.mydaybook.user.application.ports.input.IUserCommandPort;
import com.app.mydaybook.user.application.ports.output.IUserCommandPersistentPort;
import com.app.mydaybook.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCommandService implements IUserCommandPort{
    
    private final IUserCommandPersistentPort userCommandPersistentPort;

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userCommandPersistentPort.createUser(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        return userCommandPersistentPort.updateUser(id, user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userCommandPersistentPort.deleteUser(id);
    }
}
