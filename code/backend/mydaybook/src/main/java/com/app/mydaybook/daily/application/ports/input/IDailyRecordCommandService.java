package com.app.mydaybook.daily.application.ports.input;

import com.app.mydaybook.daily.domain.model.DailyRecord;

public interface IDailyRecordCommandService {
    public DailyRecord createDailyRecord(DailyRecord dailyRecord);
    public DailyRecord updateDailyRecord(DailyRecord dailyRecord);
}
