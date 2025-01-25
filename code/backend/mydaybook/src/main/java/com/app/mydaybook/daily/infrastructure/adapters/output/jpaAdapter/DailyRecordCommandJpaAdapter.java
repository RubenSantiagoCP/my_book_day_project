package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter;


import org.springframework.stereotype.Component;

import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;
import com.app.mydaybook.daily.application.ports.output.IDailyRecordCommandPersistentPort;
import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyRecordEntity;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.mapper.IDailyRecordJpaMapper;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.repository.IDailyRecordRepository;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DailyRecordCommandJpaAdapter implements IDailyRecordCommandPersistentPort {

    private final IDailyRecordJpaMapper dailyRecordJpaMapper;
    private final IDailyRecordRepository dailyRecordRepository;
    private final IUserRepository userRepository;

    private final ExceptionManager exceptionManager;

    @Override
    public DailyRecord createDailyRecord(DailyRecord dailyRecord) {
        UserEntity userEntity = userRepository.findById(dailyRecord.getUser().getId())
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.USER_NOT_FOUND));
        DailyRecordEntity dailyRecordEntity = dailyRecordJpaMapper.toDailyRecordEntity(dailyRecord);
        dailyRecordEntity.setUser(userEntity);
        dailyRecordEntity = dailyRecordRepository.save(dailyRecordEntity);
        return dailyRecordJpaMapper.toDailyRecord(dailyRecordEntity);
    }

    @Override
    public DailyRecord updateDailyRecord(DailyRecord dailyRecord) {
        DailyRecordEntity dailyRecordEntity = dailyRecordRepository.findByDateAndUserId(
                dailyRecord.getDate(), dailyRecord.getUser().getId());

        if (dailyRecordEntity == null) {
            return createDailyRecord(dailyRecord);
        } else {
            dailyRecordEntity.setNotes(dailyRecord.getNotes());
            dailyRecordEntity = dailyRecordRepository.save(dailyRecordEntity);
            return dailyRecordJpaMapper.toDailyRecord(dailyRecordEntity);
        }

    }
}
