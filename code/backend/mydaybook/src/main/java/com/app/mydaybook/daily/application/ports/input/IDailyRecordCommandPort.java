package com.app.mydaybook.daily.application.ports.input;

import com.app.mydaybook.daily.domain.model.DailyRecord;

public interface IDailyRecordCommandPort {
    public DailyRecord createDailyRecord(DailyRecord dailyRecord);
    public void updateDailyRecord(DailyRecord dailyRecord);
}
