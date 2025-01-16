package com.app.mydaybook.activities.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.ITaskQueryPort;
import com.app.mydaybook.activities.application.ports.output.ITaskQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Task;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskQueryService implements ITaskQueryPort {
    private final ITaskQueryPersistentPort taskQueryPersistentPort;

    @Override
    public List<Task> getAllTasks() {
        return taskQueryPersistentPort.getAllTasks();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskQueryPersistentPort.getTaskById(id);
    }
}
