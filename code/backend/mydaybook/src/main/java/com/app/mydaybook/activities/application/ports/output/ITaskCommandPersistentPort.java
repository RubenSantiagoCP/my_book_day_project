package com.app.mydaybook.activities.application.ports.output;

import com.app.mydaybook.activities.domain.model.Task;

public interface ITaskCommandPersistentPort {
    public Task createTask(Task task);
    public Task updateTask(Long id, Task task);
    public boolean deleteTask(Long id);
}
