package com.app.mydaybook.user.application.ports.output;

import com.app.mydaybook.user.domain.model.User;

public interface IUserCommandPersistentPort {
    public User createUser(User user);
    public User updateUser(Long id, User user);
    public boolean deleteUser(Long id);
}
