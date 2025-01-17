package com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.TaskCreateRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.TaskCreateResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITaskRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "state", ignore = true)
    Task toTask(TaskCreateRequest taskCreateRequest);
    
    TaskCreateRequest toTaskCreateRequest(Task task);

    List<Task> toTaskList(List<TaskCreateRequest> taskCreateRequests);

    List<TaskCreateRequest> toTaskCreateRequestList(List<Task> tasks);

    TaskCreateResponse toTaskCreateResponse(Task task);

}
