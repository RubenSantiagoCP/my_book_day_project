package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;

public interface ITaskRepository extends JpaRepository<TaskEntity, Long> {
    
}
