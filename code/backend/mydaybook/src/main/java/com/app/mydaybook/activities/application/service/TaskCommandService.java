package com.app.mydaybook.activities.application.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.ITaskCommandPort;
import com.app.mydaybook.activities.application.ports.output.ITaskCommandPersistentPort;
import com.app.mydaybook.activities.domain.enums.TaskFrequency;
import com.app.mydaybook.activities.domain.enums.TaskState;
import com.app.mydaybook.activities.domain.model.Task;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TaskCommandService implements ITaskCommandPort{
    private final ITaskCommandPersistentPort taskCommandPersistentPort;

    @Override
    public Task createTask(Task task) {
        establistValueDefault(task);
        return taskCommandPersistentPort.createTask(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskCommandPersistentPort.updateTask(id, task);
    }

    @Override
    public boolean deleteTask(Long id) {
        taskCommandPersistentPort.deleteTask(id);
        return true;
    }

    private void establistValueDefault(Task task) {

        //Set default values for frequency
        if(task.getFrequency() == null) {
            task.setFrequency(TaskFrequency.NONE);
        }

        //Set default values for state
        if(task.getState() == null) {
            task.setState(TaskState.PENDING);
        }

        //Set default values for startDate and endDate
        if(task.getStartDate() == null) {
            task.setStartDate(LocalDateTime.now());
        }

        if(task.getEndDate() == null) {
            task.setEndDate( task.getStartDate());
        }
    }
}
