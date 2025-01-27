package com.app.mydaybook.daily.application.service;

import org.springframework.stereotype.Service;

import com.app.mydaybook.daily.application.ports.input.IDailyTaskCommandService;
import com.app.mydaybook.daily.application.ports.output.IDailyTaskCommPersitentPort;
import com.app.mydaybook.daily.domain.model.DailyTask;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyTaskCommandService implements IDailyTaskCommandService {
    
    private final IDailyTaskCommPersitentPort dailyTaskCommPersitentPort;
    @Override
    public void markTaskDone(DailyTask dailyTask) {
        dailyTaskCommPersitentPort.markTaskDone(dailyTask);
    }

    @Override
    public void markTaskUndone(DailyTask dailyTask) {
        dailyTaskCommPersitentPort.markTaskUndone(dailyTask);
    }
    
}
