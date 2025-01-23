package com.app.mydaybook.user.application.ports.input;

import com.app.mydaybook.user.domain.model.User;

public interface IUserCommandPort {
    public User createUser(User user);
    public User updateUser(Long id, User user);
    public boolean deleteUser(Long id);
}
