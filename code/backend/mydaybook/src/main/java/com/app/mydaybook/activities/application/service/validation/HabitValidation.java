package com.app.mydaybook.activities.application.service.validation;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.output.IHabitQueryPersistentPort;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitValidation {
    private final IHabitQueryPersistentPort habitQueryPersistentPort;
    private final ExceptionManager exceptionManager;

    public void validateConflictName(String name, Long userId) {
        if (habitQueryPersistentPort.existedConflictByName(name, userId)) {
            throw exceptionManager.createException(ErrorCode.HABIT_ALREADY_EXISTS);
        }
    }

}
