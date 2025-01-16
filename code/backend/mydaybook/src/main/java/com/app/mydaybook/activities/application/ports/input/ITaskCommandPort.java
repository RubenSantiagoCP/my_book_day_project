package com.app.mydaybook.activities.application.ports.input;

import com.app.mydaybook.activities.domain.model.Task;

public interface ITaskCommandPort {
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    boolean deleteTask(Long id);
}
