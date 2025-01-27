package com.app.mydaybook.activities.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.activities.application.service.impl.TaskCommandService;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.TaskRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.TaskResponse;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper.ITaskRestMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskCommandController {
    
    private final TaskCommandService taskCommandService;
    private final ITaskRestMapper taskRestMapper;

    @PostMapping("/create")
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest taskCreateRequest) {
        Task task = taskRestMapper.toTask(taskCreateRequest);
        task = taskCommandService.createTask(task);
        return ResponseEntity.ok(taskRestMapper.toTaskResponse(task));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskResponse> updateTask(@Valid @RequestBody TaskRequest taskUpdateRequest, @PathVariable Long id){
        Task task = taskRestMapper.toTask(taskUpdateRequest);
        task = taskCommandService.updateTask(id, task);
        return ResponseEntity.ok(taskRestMapper.toTaskResponse(task));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id){
        return ResponseEntity.ok(taskCommandService.deleteTask(id));
    }
    
}
