package com.app.mydaybook.daily.application.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.app.mydaybook.daily.application.ports.input.IDailyRecordQueryService;
import com.app.mydaybook.daily.application.ports.output.IDailyRecordQueryPersistentPort;
import com.app.mydaybook.daily.domain.model.DailyRecord;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyRecordQueryService implements IDailyRecordQueryService {
    
    private final IDailyRecordQueryPersistentPort queryPersistentPort;
    
    @Override
    public DailyRecord getDailyRecordByDate(LocalDate date, Long userId) {
        return queryPersistentPort.getDailyRecordByDate(date, userId);
    }
    
    
}
