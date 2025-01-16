package com.app.mydaybook.application.ports.output;

import java.util.List;

import com.app.mydaybook.domain.model.activities.Task;

public interface ITaskQueryPersistentPort {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
}
