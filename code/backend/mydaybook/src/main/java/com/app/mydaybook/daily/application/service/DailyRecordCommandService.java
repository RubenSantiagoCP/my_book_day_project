package com.app.mydaybook.daily.application.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.app.mydaybook.daily.application.ports.input.IDailyRecordCommandService;
import com.app.mydaybook.daily.application.ports.output.IDailyRecordCommandPersistentPort;
import com.app.mydaybook.daily.application.ports.output.IDailyRecordQueryPersistentPort;
import com.app.mydaybook.daily.domain.model.DailyRecord;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyRecordCommandService implements IDailyRecordCommandService{
    
    private final IDailyRecordCommandPersistentPort commandPersistentPort;
    private final IDailyRecordQueryPersistentPort queryPersistentPort;

    @Override
    public DailyRecord createDailyRecord(DailyRecord dailyRecord) {
        DailyRecord dailyRecordVerified = verifDailyRecordByDate(dailyRecord.getDate(), dailyRecord.getUser().getId());
        if (dailyRecordVerified != null) {
            return this.updateDailyRecord(dailyRecord);
        }
        return commandPersistentPort.createDailyRecord(dailyRecord);
    }

    @Override
    public DailyRecord updateDailyRecord(DailyRecord dailyRecord) {
        return commandPersistentPort.updateDailyRecord(dailyRecord);
    }

    private DailyRecord verifDailyRecordByDate(LocalDate date, Long userId) {
        return queryPersistentPort.getDailyRecordByDate(date, userId);
    }
    
}
