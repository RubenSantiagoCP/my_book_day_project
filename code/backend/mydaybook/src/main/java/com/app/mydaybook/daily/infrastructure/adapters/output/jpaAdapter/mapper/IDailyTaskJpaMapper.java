package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.daily.domain.model.DailyTask;
import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyTaskEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDailyTaskJpaMapper {
    
    DailyTask toDailyTask(DailyTaskEntity dailyTaskEntity);

    DailyTaskEntity toDailyTaskEntity(DailyTask dailyTask);

}
