package com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.TaskRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.TaskResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITaskRestMapper {

    @Mapping(target = "user.id", source = "userId")
    Task toTask(TaskRequest taskRequest);
    
    @Mapping(target = "userId", source = "user.id")
    List<TaskResponse> toTaskResponseList(List<Task> tasks);

    @Mapping(target = "userId", source = "user.id")
    TaskResponse toTaskResponse(Task task);

}
