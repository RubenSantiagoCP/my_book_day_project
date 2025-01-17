package com.app.mydaybook.activities.application.ports.output;

import java.util.List;

import com.app.mydaybook.activities.domain.model.Task;

public interface ITaskQueryPersistentPort {
    public List<Task> getAllTasks();
    public Task getTaskById(Long id);
}
