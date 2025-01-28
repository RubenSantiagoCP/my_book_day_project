package com.app.mydaybook.daily.application.service.impl;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.service.validation.TaskValidation;
import com.app.mydaybook.daily.application.ports.input.IDailyTaskCommandService;
import com.app.mydaybook.daily.application.ports.output.IDailyTaskCommPersitentPort;
import com.app.mydaybook.daily.domain.model.DailyTask;
import com.app.mydaybook.user.application.service.UserValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyTaskCommandService implements IDailyTaskCommandService {

    private final IDailyTaskCommPersitentPort dailyTaskCommPersitentPort;
    private final UserValidationService userValidationService;
    private final TaskValidation taskConflictsValidation;

    @Override
    public void markTaskDone(DailyTask dailyTask) {
        userValidationService.validateUserExists(dailyTask.getUserId());
        taskConflictsValidation.existsTaskInDate(dailyTask.getUserId(), dailyTask.getTaskId(), dailyTask.getDate());
        dailyTaskCommPersitentPort.markTaskDone(dailyTask);
    }

    @Override
    public void markTaskUndone(DailyTask dailyTask) {
        userValidationService.validateUserExists(dailyTask.getUserId());
        taskConflictsValidation.existsTaskInDate(dailyTask.getUserId(), dailyTask.getTaskId(), dailyTask.getDate());
        dailyTaskCommPersitentPort.markTaskUndone(dailyTask);
    }

}
