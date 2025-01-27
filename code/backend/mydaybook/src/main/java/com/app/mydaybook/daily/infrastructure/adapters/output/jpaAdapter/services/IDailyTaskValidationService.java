package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.services;

import com.app.mydaybook.daily.domain.model.DailyTask;

public interface IDailyTaskValidationService {
    void validateUserAndTask(DailyTask dailyTask);
}
