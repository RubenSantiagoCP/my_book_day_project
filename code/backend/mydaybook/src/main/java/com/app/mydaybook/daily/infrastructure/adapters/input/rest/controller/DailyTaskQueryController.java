package com.app.mydaybook.daily.infrastructure.adapters.input.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.daily.application.service.impl.DailyTaskQueryService;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.request.TaskDoneRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/daily/task")
@RequiredArgsConstructor
public class DailyTaskQueryController {
    
    private final DailyTaskQueryService dailyTaskQueryService;

    @GetMapping("/getDoneTasksByDate")
    public ResponseEntity<List<Long>> getDoneTasksByDate(@RequestBody TaskDoneRequest taskDoneRequest) {
        List<Long> doneTasks = dailyTaskQueryService.getDoneTasksByDate(taskDoneRequest.getUserId(), taskDoneRequest.getDate());
        return ResponseEntity.ok(doneTasks);
    }
}
