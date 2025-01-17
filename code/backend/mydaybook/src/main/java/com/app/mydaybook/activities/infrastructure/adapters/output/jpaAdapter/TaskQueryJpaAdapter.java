package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;


import java.util.List;

import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.ITaskQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Task;

@Component
public class TaskQueryJpaAdapter implements ITaskQueryPersistentPort {

    @Override
    public List<Task> getAllTasks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllTasks'");
    }

    @Override
    public Task getTaskById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTaskById'");
    }
    
}
