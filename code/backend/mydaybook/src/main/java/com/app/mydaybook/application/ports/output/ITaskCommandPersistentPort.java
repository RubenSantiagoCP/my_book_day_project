package com.app.mydaybook.application.ports.output;

import com.app.mydaybook.domain.model.activities.Task;

public interface ITaskCommandPersistentPort {
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    boolean deleteTask(Long id);
}
