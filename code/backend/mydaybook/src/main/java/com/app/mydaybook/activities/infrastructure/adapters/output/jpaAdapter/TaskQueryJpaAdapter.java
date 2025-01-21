package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.ITaskQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.ITaskJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ITaskRepository;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaskQueryJpaAdapter implements ITaskQueryPersistentPort {

    private final ITaskRepository taskRepository;
    private final ITaskJpaMapper taskJpaMapper;

    private final ExceptionManager exceptionManager;

    @Override
    public List<Task> getAllTasks() {
        List<TaskEntity> lTaskEntities = taskRepository.findAll();
        return taskJpaMapper.toTaskList(lTaskEntities); 
    }

    @Override
    public Task getTaskById(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> exceptionManager.createException(ErrorCode.TASK_NOT_FOUND) );
        return taskJpaMapper.toTask(taskEntity);
    }

    @Override
    public boolean existsTaskInDate(LocalDateTime date, String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsTaskInDate'");
    }
    
}
