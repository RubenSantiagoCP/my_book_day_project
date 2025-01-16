package com.app.mydaybook.application.ports.input.activities;

import java.util.List;

import com.app.mydaybook.domain.model.activities.Task;

public interface ITaskQueryPort {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
}
