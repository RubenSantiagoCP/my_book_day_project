package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.app.mydaybook.daily.application.ports.output.IDailyRecordQueryPersistentPort;
import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyRecordEntity;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.mapper.IDailyRecordJpaMapper;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.repository.IDailyRecordRepository;
import com.app.mydaybook.user.application.service.UserValidationService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DailyRecordQueryJpaAdapter implements IDailyRecordQueryPersistentPort {
    
    private final IDailyRecordJpaMapper dailyRecordJpaMapper;
    private final IDailyRecordRepository dailyRecordRepository;
    private final UserValidationService userValidationService;
    
    @Override
    public DailyRecord getDailyRecordByDate(LocalDate date, Long userId) {
        userValidationService.validateUserExists(userId);
        DailyRecordEntity dailyRecordEntity = dailyRecordRepository.findByDateAndUserId(date, userId);
        return dailyRecordJpaMapper.toDailyRecord(dailyRecordEntity);
    }
}
