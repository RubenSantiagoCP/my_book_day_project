package com.app.mydaybook.daily.application.ports.input;

import java.time.LocalDate;

import com.app.mydaybook.daily.domain.model.DailyRecord;

public interface IDailyRecordQueryPort {
    DailyRecord getDailyRecordByDate(LocalDate date, Long userId);
}
