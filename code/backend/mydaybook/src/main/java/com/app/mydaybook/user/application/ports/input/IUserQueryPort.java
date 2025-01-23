package com.app.mydaybook.user.application.ports.input;

import java.util.List;

import com.app.mydaybook.user.domain.model.User;

public interface IUserQueryPort {
    public User getUserById(Long id);
    public List<User> getAllUsers();
}
