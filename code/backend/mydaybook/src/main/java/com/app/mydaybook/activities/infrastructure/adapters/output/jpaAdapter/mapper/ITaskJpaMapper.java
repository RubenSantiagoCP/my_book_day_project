package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITaskJpaMapper {
    
    Task toTask(TaskEntity taskEntity);

    TaskEntity toTaskEntity(Task task);

    List<Task> toTaskList(List<TaskEntity> taskEmEntities);

    List<TaskEntity> toTaskEntities(List<Task> tasks);
}
