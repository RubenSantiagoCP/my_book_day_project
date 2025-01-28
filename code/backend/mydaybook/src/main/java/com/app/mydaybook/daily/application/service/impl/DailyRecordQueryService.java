package com.app.mydaybook.daily.application.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.app.mydaybook.daily.application.ports.input.IDailyRecordQueryService;
import com.app.mydaybook.daily.application.ports.output.IDailyRecordQueryPersistentPort;
import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.user.application.service.UserValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyRecordQueryService implements IDailyRecordQueryService {

    private final IDailyRecordQueryPersistentPort queryPersistentPort;
    private final UserValidationService userValidationService;


    @Override
    public DailyRecord getDailyRecordByDate(LocalDate date, Long userId) {
        userValidationService.validateUserExists(userId);
        return queryPersistentPort.getDailyRecordByDate(date, userId);
    }

}
