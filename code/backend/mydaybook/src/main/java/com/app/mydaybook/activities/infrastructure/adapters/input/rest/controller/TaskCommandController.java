package com.app.mydaybook.activities.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.activities.application.service.TaskCommandService;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.TaskCreateRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.TaskCreateResponse;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper.ITaskRestMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskCommandController {
    
    private final TaskCommandService taskCommandService;
    private final ITaskRestMapper taskRestMapper;

    @RequestMapping("/create")
    public ResponseEntity<TaskCreateResponse> createTask(@Valid @RequestBody TaskCreateRequest taskCreateRequest) {
        Task task = taskRestMapper.toTask(taskCreateRequest);
        task = taskCommandService.createTask(task);
        return ResponseEntity.ok(taskRestMapper.toTaskCreateResponse(task));
    }
    
}
