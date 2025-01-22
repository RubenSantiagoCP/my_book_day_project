package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.ITaskCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.ITaskJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ITaskRepository;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaskCommandJpaAdapter implements ITaskCommandPersistentPort{

    private final ITaskRepository taskRepository;
    private final ITaskJpaMapper taskJpaMapper;
    private final ExceptionManager exceptionManager;


    @Override
    public Task createTask(Task task) {
        TaskEntity taskEntity = taskJpaMapper.toTaskEntity(task);
        try{
            taskEntity = taskRepository.save(taskEntity);
            return taskJpaMapper.toTask(taskEntity);
        }catch(DataIntegrityViolationException ex){
            throw exceptionManager.createException(ErrorCode.TASK_ALREADY_EXISTS);
        }
    }

    @Override
    public Task updateTask(Long id, Task task) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow();
        taskEntity.setDescription(task.getDescription());
        taskEntity.setEndDate(task.getEndDate());
        taskEntity.setFrequency(task.getFrequency());
        taskEntity.setPriority(task.getPriority());
        taskEntity.setStartDate(task.getStartDate());
        taskEntity.setState(task.getState());
        taskEntity.setTitle(task.getTitle());
        taskEntity = taskRepository.save(taskEntity);
        return taskJpaMapper.toTask(taskEntity);
    }

    @Override
    public boolean deleteTask(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow();
        if(taskEntity!=null){
            taskRepository.delete(taskEntity);
            return true;
        }
        return false;
    }
    
}
