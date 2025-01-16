package com.app.mydaybook.application.service;

import org.springframework.stereotype.Service;

import com.app.mydaybook.application.ports.input.activities.ITaskCommandPort;
import com.app.mydaybook.application.ports.output.ITaskCommandPersistentPort;
import com.app.mydaybook.domain.model.activities.Task;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TaskCommandService implements ITaskCommandPort{
    private final ITaskCommandPersistentPort taskCommandPersistentPort;

    @Override
    public Task createTask(Task task) {
        return taskCommandPersistentPort.createTask(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskCommandPersistentPort.updateTask(id, task);
    }

    @Override
    public boolean deleteTask(Long id) {
        taskCommandPersistentPort.deleteTask(id);
        return true;
    }
}
