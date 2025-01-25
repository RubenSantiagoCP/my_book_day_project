package com.app.mydaybook.daily.application.ports.output;

import com.app.mydaybook.daily.domain.model.DailyRecord;

public interface IDailyRecordCommandPersistentPort {
    public DailyRecord createDailyRecord(DailyRecord dailyRecord);
    public DailyRecord updateDailyRecord(DailyRecord dailyRecord);
}
