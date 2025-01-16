package com.app.mydaybook.application.ports.input.activities;

import com.app.mydaybook.domain.model.activities.Task;

public interface ITaskCommandPort {
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    boolean deleteTask(Long id);
}
