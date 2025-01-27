package com.app.mydaybook.daily.application.ports.input;

import com.app.mydaybook.daily.domain.model.DailyTask;

public interface IDailyTaskCommandService {
    public void markTaskDone(DailyTask dailyTask);
    public void markTaskUndone(DailyTask dailyTask);
}
