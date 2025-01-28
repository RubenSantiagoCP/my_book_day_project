package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyRecordEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDailyRecordJpaMapper {
    
    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "user.dailyRecords", ignore = true)
    @Mapping(target = "user.dailyTasks", ignore = true)
    DailyRecord toDailyRecord(DailyRecordEntity dailyRecordEntity);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "user.dailyRecords", ignore = true)
    @Mapping(target = "user.dailyTasks", ignore = true)
    DailyRecordEntity toDailyRecordEntity(DailyRecord dailyRecord);
}
