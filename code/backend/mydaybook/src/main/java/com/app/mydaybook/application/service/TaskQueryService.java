package com.app.mydaybook.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.application.ports.input.activities.ITaskQueryPort;
import com.app.mydaybook.application.ports.output.ITaskQueryPersistentPort;
import com.app.mydaybook.domain.model.activities.Task;

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
