package com.app.mydaybook.activities.application.ports.output;

import java.time.LocalDate;
import java.util.List;

import com.app.mydaybook.activities.domain.model.Task;

public interface ITaskQueryPersistentPort {
    Task getTaskById(Long id);
    List<Task> getTasksByUserId(Long userId);
    List<Task> getTasksByDate(Long userId, LocalDate date);
    boolean existsConflictByUserAndTitleAndDateRange(Task task);
}
