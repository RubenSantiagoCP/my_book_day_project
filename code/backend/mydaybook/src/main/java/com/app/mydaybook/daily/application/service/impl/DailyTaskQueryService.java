package com.app.mydaybook.daily.application.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.daily.application.ports.input.IDailyTaskQueryService;
import com.app.mydaybook.daily.application.ports.output.IDailyTaskQueryPersistentPort;
import com.app.mydaybook.user.application.service.UserValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyTaskQueryService implements IDailyTaskQueryService {

    private final IDailyTaskQueryPersistentPort dailyTaskQueryPersistentPort;
    private final UserValidationService userValidationService;

    @Override
    public List<Long> getDoneTasksByDate(Long userId, LocalDate date) {
        userValidationService.validateUserExists(userId);
        return dailyTaskQueryPersistentPort.getDoneTasksByDate(userId, date);
    }
}
