package com.app.mydaybook.daily.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.daily.application.ports.input.IDailyTaskQueryService;
import com.app.mydaybook.daily.application.ports.output.IDailyTaskQueryPersistentPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DailyTaskQueryService implements IDailyTaskQueryService {

    private final IDailyTaskQueryPersistentPort dailyTaskQueryPersistentPort;

    @Override
    public List<Long> getDoneTasksByDate(Long userId, LocalDate date) {
        return dailyTaskQueryPersistentPort.getDoneTasksByDate(userId, date);
    }
}
