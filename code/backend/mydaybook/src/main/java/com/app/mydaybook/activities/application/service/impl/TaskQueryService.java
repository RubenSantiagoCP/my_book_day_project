package com.app.mydaybook.activities.application.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.ITaskQueryPort;
import com.app.mydaybook.activities.application.ports.output.ITaskQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.user.application.service.UserValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskQueryService implements ITaskQueryPort {
    private final ITaskQueryPersistentPort taskQueryPersistentPort;
    private final UserValidationService userValidationService;

    @Override
    public Task getTaskById(Long id) {
        return taskQueryPersistentPort.getTaskById(id);
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        userValidationService.validateUserExists(userId);
        return taskQueryPersistentPort.getTasksByUserId(userId);
    }

    @Override
    public List<Task> getTasksByDate(Long userId, LocalDate date) {
        userValidationService.validateUserExists(userId);
        return taskQueryPersistentPort.getTasksByDate(userId, date);
    }
}
