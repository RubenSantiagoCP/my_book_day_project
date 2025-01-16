package com.app.mydaybook.activities.application.ports.input;

import java.util.List;

import com.app.mydaybook.activities.domain.model.Task;

public interface ITaskQueryPort {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
}
