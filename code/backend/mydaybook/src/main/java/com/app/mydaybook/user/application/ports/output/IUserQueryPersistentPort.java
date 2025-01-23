package com.app.mydaybook.user.application.ports.output;

import java.util.List;

import com.app.mydaybook.user.domain.model.User;

public interface IUserQueryPersistentPort {
    public User getUserById(Long id);
    public List<User> getAllUsers();
}
