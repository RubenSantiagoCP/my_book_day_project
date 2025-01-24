package com.app.mydaybook.activities.application.ports.input;

import java.time.LocalDate;
import java.util.List;

import com.app.mydaybook.activities.domain.model.Task;

public interface ITaskQueryPort {
    Task getTaskById(Long id);
    List<Task> getTasksByUserId(Long userId);
    List<Task> getTasksByDate(Long userId, LocalDate date);
}
