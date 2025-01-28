package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter;


import org.springframework.stereotype.Component;

import com.app.mydaybook.daily.application.ports.output.IDailyRecordCommandPersistentPort;
import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyRecordEntity;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.mapper.IDailyRecordJpaMapper;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.repository.IDailyRecordRepository;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DailyRecordCommandJpaAdapter implements IDailyRecordCommandPersistentPort {

    private final IDailyRecordJpaMapper dailyRecordJpaMapper;
    private final IDailyRecordRepository dailyRecordRepository;

    @Override
    public DailyRecord createDailyRecord(DailyRecord dailyRecord) {
        DailyRecordEntity dailyRecordEntity = dailyRecordJpaMapper.toDailyRecordEntity(dailyRecord);
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
