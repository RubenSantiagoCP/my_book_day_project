package com.app.mydaybook.user.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.user.application.ports.input.IUserQueryPort;
import com.app.mydaybook.user.application.ports.output.IUserQueryPersistentPort;
import com.app.mydaybook.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserQueryService implements IUserQueryPort{
    private final IUserQueryPersistentPort userQueryPersistentPort;

    @Override
    public User getUserById(Long id) {
        return userQueryPersistentPort.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userQueryPersistentPort.getAllUsers();
    }
}
