package com.app.mydaybook.daily.infrastructure.adapters.input.rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.daily.application.service.impl.DailyTaskCommandService;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.request.TaskDailyRequest;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.mapper.IDailyTaskRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/daily/task/")
@RequiredArgsConstructor
public class DailyTaskCommController {
    
    private final DailyTaskCommandService dailyTaskCommandService;
    private final IDailyTaskRestMapper dailyTaskRestMapper;

    @PostMapping("/markTaskDone")
    public void markTaskDone(@RequestBody TaskDailyRequest taskDailyRequest) {
        dailyTaskCommandService.markTaskDone(dailyTaskRestMapper.toDailyTask(taskDailyRequest));
    }

    @PostMapping("/markTaskUndone")
    public void markTaskUndone(@RequestBody TaskDailyRequest taskDailyRequest) {
        dailyTaskCommandService.markTaskUndone(dailyTaskRestMapper.toDailyTask(taskDailyRequest));
    }
}
