package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITaskJpaMapper {
    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    Task toTask(TaskEntity taskEntity);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    TaskEntity toTaskEntity(Task task);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    List<Task> toTaskList(List<TaskEntity> taskEmEntities);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    List<TaskEntity> toTaskEntities(List<Task> tasks);
}
