package com.app.mydaybook.activities.application.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.ITaskCommandPort;
import com.app.mydaybook.activities.application.ports.output.ITaskCommandPersistentPort;
import com.app.mydaybook.activities.domain.enums.TaskFrequency;
import com.app.mydaybook.activities.domain.enums.TaskState;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TaskCommandService implements ITaskCommandPort{
    private final ITaskCommandPersistentPort taskCommandPersistentPort;
    private final ExceptionManager exceptionManager;

    @Override
    public Task createTask(Task task) {
        establistValueDefault(task);
        validateEndDate(task);
        validateFrecuency(task);
        return taskCommandPersistentPort.createTask(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        establistValueDefault(task);
        validateEndDate(task);
        validateFrecuency(task);
        return taskCommandPersistentPort.updateTask(id, task);
    }

    @Override
    public boolean deleteTask(Long id) {
        taskCommandPersistentPort.deleteTask(id);
        return true;
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

    private void validateEndDate(Task task) {
        //Set default values for endDate
        if(task.getEndDate() == null) {
            task.setEndDate(task.getStartDate());
        }

        if(task.getEndDate().isBefore(task.getStartDate())) {
            throw exceptionManager.createException(ErrorCode.END_DATE_BEFORE_START_DATE);
        }
    }

    private void validateFrecuency(Task task) {
        //Set default values for frecuency
        if(task.getFrequency() == null) {
            task.setFrequency(TaskFrequency.NONE);
        }

        if(task.getStartDate().toLocalDate().isBefore(task.getEndDate().toLocalDate())) {
            task.setFrequency(TaskFrequency.DAILY);
        }

        if(task.getStartDate().equals(task.getEndDate())) {
            task.setFrequency(TaskFrequency.NONE);
        }
    }
}
