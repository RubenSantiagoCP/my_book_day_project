package com.app.mydaybook.activities.application.ports.output;

import com.app.mydaybook.activities.domain.model.Task;

public interface ITaskCommandPersistentPort {
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    boolean deleteTask(Long id);
}
