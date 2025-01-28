package com.app.mydaybook.daily.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.daily.domain.model.DailyTask;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.request.TaskDailyRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDailyTaskRestMapper {

    @Mapping(target = "task.id", source = "taskId")
    @Mapping(target = "user.id", source = "userId")
    DailyTask toDailyTask(TaskDailyRequest taskDailyRequest);

}
