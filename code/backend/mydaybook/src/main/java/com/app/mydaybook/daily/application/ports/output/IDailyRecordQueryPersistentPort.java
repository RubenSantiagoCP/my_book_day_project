package com.app.mydaybook.daily.application.ports.output;

import java.time.LocalDate;

import com.app.mydaybook.daily.domain.model.DailyRecord;

public interface IDailyRecordQueryPersistentPort {
    DailyRecord getDailyRecordByDate(LocalDate date, Long userId);
}
