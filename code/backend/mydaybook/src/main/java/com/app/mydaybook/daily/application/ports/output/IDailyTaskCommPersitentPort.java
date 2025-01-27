package com.app.mydaybook.daily.application.ports.output;

import com.app.mydaybook.daily.domain.model.DailyTask;

public interface IDailyTaskCommPersitentPort {
    public void markTaskDone(DailyTask dailyTask);
    public void markTaskUndone(DailyTask dailyTask);
}
