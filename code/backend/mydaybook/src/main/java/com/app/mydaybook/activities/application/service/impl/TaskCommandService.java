package com.app.mydaybook.activities.application.service.impl;


import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.ITaskCommandPort;
import com.app.mydaybook.activities.application.ports.output.ITaskCommandPersistentPort;
import com.app.mydaybook.activities.application.service.validation.TaskValidation;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.domain.services.TaskValidator;
import com.app.mydaybook.user.application.service.UserValidationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TaskCommandService implements ITaskCommandPort{
    private final ITaskCommandPersistentPort taskCommandPersistentPort;
    private final TaskValidator taskValidator;
    private final TaskValidation taskConflictsValidation;
    private final UserValidationService userValidationService;


    @Override
    public Task createTask(Task task) {
        userValidationService.validateUserExists(task.getUserId());
        taskValidator.validateTask(task);
        taskConflictsValidation.validateConflictName(task);
        return taskCommandPersistentPort.createTask(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        userValidationService.validateUserExists(task.getUserId());
        taskValidator.validateTask(task);
        taskConflictsValidation.validateConflictName(task);
        return taskCommandPersistentPort.updateTask(id, task);
    }

    @Override
    public boolean deleteTask(Long id) {
        taskCommandPersistentPort.deleteTask(id);
        return true;
    }

   
}
