package com.app.mydaybook.user.application.service;

import org.springframework.stereotype.Service;

import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;
import com.app.mydaybook.user.application.ports.output.IUserQueryPersistentPort;
import com.app.mydaybook.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserValidationService {
    private final IUserQueryPersistentPort userQueryPersistentPort;
    private final ExceptionManager exceptionManager;

    public User validateUserExists(Long userId) {
        User userExists = userQueryPersistentPort.getUserById(userId);
        if (userExists == null) {
            throw exceptionManager.createException(ErrorCode.USER_NOT_FOUND);
        }
        return userExists;
    }
}
