package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.mydaybook.daily.application.ports.output.IDailyTaskQueryPersistentPort;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.repository.IDailyTaskRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DailyTaskQueryJpaAdapter implements IDailyTaskQueryPersistentPort {

    private final IDailyTaskRepository dailyTaskRepository;

    @Override
    public List<Long> getDoneTasksByDate(Long userId, LocalDate date) {
        return dailyTaskRepository.getDoneTasksByDate(userId, date);
        
    }
    
}
