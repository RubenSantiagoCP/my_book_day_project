package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.ITaskCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.ITaskJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ITaskRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaskCommandJpaAdapter implements ITaskCommandPersistentPort{

    private final ITaskRepository taskRepository;
    private final ITaskJpaMapper taskJpaMapper;

    @Override
    public Task createTask(Task task) {
        TaskEntity taskEntity = taskJpaMapper.toTaskEntity(task);
        taskEntity = taskRepository.save(taskEntity);
        return taskJpaMapper.toTask(taskEntity);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTask'");
    }

    @Override
    public boolean deleteTask(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTask'");
    }
    
}
