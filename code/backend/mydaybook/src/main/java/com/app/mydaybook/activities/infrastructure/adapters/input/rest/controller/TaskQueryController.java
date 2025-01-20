package com.app.mydaybook.activities.infrastructure.adapters.input.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.activities.application.service.TaskQueryService;
import com.app.mydaybook.activities.domain.model.Task;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.TaskResponse;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper.ITaskRestMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor

@RestController
@RequestMapping("/task")
public class TaskQueryController {
    private final TaskQueryService taskQueryService;
    private final ITaskRestMapper taskRestMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findTaskById(@PathVariable Long id){
        Task task = taskQueryService.getTaskById(id);
        return ResponseEntity.ok(taskRestMapper.toTaskResponse(task));
    }

    @GetMapping("/allTasks")
    public ResponseEntity<List<TaskResponse>> findAllTasks(){
        List<Task> tasks = taskQueryService.getAllTasks();
        List<TaskResponse> taskResponses = taskRestMapper.toTaskResponseList(tasks);
        return ResponseEntity.ok(taskResponses);
    }
    
}
