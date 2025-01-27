package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.mydaybook.daily.application.ports.output.IDailyTaskQueryPersistentPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DailyTaskQueryJpaAdapter implements IDailyTaskQueryPersistentPort {
    @Override
    public List<Long> getDoneTasksByDate(Long userId, LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDoneTasksByDate'");
    }
    
}
