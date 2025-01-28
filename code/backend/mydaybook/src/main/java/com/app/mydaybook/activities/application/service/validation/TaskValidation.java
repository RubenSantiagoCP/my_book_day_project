package com.app.mydaybook.activities.application.service.validation;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.output.ITaskQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskValidation {

    private final ITaskQueryPersistentPort taskQueryPersistentPort;
    private final ExceptionManager exceptionManager;

    public void validateConflictName(Task task) {
        if (taskQueryPersistentPort.existsConflictByUserAndTitleAndDateRange(task)) {
            throw exceptionManager.createException(ErrorCode.TASK_ALREADY_EXISTS);
        }
    }

    public void existsTaskByUser(Long userId, Long taskId) {
        if (!taskQueryPersistentPort.existsTaskByUser(userId, taskId)) {
            throw exceptionManager.createException(ErrorCode.TASK_NOT_FOUND);
        }
    }

    public void existsTaskInDate(Long userId, Long taskId, LocalDate date) {
        if (!taskQueryPersistentPort.existsTaskInDate(userId, date, taskId)) {
            throw exceptionManager.createException(ErrorCode.TASK_NOT_FOUND);
        }
    }
}
