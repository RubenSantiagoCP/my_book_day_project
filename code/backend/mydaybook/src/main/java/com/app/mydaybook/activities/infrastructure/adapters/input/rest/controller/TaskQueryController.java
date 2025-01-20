package com.app.mydaybook.activities.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.activities.application.service.TaskQueryService;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.TaskResponse;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper.ITaskRestMapper;

@RestController
@RequestMapping("/habit")
public class TaskQueryController {
    private TaskQueryService taskQueryService;
    private ITaskRestMapper taskRestMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findTaskById(@PathVariable Long id){
        Task task = taskQueryService.getTaskById(id);
        return ResponseEntity.ok(taskRestMapper.toTaskResponse(task));
    }

    
}
