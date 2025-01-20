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

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "state", ignore = true)
    Task toTask(TaskRequest taskRequest);
    
    TaskRequest toTaskRequest(Task task);

    List<Task> toTaskList(List<TaskRequest> taskRequests);

    List<TaskResponse> toTaskResponseList(List<Task> tasks);

    TaskResponse toTaskResponse(Task task);

}
