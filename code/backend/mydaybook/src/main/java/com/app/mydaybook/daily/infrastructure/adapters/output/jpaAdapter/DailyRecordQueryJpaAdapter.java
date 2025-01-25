package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;
import com.app.mydaybook.daily.application.ports.output.IDailyRecordQueryPersistentPort;
import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyRecordEntity;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.mapper.IDailyRecordJpaMapper;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.repository.IDailyRecordRepository;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DailyRecordQueryJpaAdapter implements IDailyRecordQueryPersistentPort {
    
    private final IDailyRecordJpaMapper dailyRecordJpaMapper;
    private final IDailyRecordRepository dailyRecordRepository;

    private final IUserRepository userRepository;

    private final ExceptionManager exceptionManager;

    
    @Override
    public DailyRecord getDailyRecordByDate(LocalDate date, Long userId) {
        if(userRepository.findById(userId)==null){
            throw exceptionManager.createException(ErrorCode.USER_NOT_FOUND);
        }
        DailyRecordEntity dailyRecordEntity = dailyRecordRepository.findByDateAndUserId(date, userId);
        return dailyRecordJpaMapper.toDailyRecord(dailyRecordEntity);
    }
}
