package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IHabitJpaMapper {
    
    Habit toHabit(HabitEntity habitEntity);

    HabitEntity toHabitEntity(Habit habit);

    List<Habit> toHabitsList(List<HabitEntity> lstHabitEntities);
}
