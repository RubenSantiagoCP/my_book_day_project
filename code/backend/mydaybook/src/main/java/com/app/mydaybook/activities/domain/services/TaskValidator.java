package com.app.mydaybook.activities.domain.services;

import com.app.mydaybook.activities.domain.model.Task;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.domain.enums.TaskFrequency;
import com.app.mydaybook.activities.domain.enums.TaskState;
import com.app.mydaybook.common.exception.ExceptionManager;
import com.app.mydaybook.common.enums.exception.ErrorCode;

@Service
public class TaskValidator {
    private final ExceptionManager exceptionManager;

    public TaskValidator(ExceptionManager exceptionManager) {
        this.exceptionManager = exceptionManager;
    }

    public void validateTask(Task task) {
        establistValueDefault(task);
        validateEndDate(task);
        validateFrecuency(task);
    }

    private void validateEndDate(Task task) {
        if (task.getEndDate() == null) {
            task.setEndDate(task.getStartDate());
        }
        if (task.getEndDate().isBefore(task.getStartDate())) {
            throw exceptionManager.createException(ErrorCode.END_DATE_BEFORE_START_DATE);
        }
    }

    private void validateFrecuency(Task task) {
        if (task.getFrequency() == null) {
            task.setFrequency(TaskFrequency.NONE);
        }
        if (task.getStartDate().toLocalDate().isBefore(task.getEndDate().toLocalDate())) {
            task.setFrequency(TaskFrequency.DAILY);
        }
        if (task.getStartDate().equals(task.getEndDate())) {
            task.setFrequency(TaskFrequency.NONE);
        }
    }

    private void establistValueDefault(Task task) {

        //Set default values for state
        if(task.getState() == null) {
            task.setState(TaskState.PENDING);
        }

        //Set default values for startDate and endDate
        if(task.getStartDate() == null) {
            task.setStartDate(LocalDateTime.now());
        }
    }
}
