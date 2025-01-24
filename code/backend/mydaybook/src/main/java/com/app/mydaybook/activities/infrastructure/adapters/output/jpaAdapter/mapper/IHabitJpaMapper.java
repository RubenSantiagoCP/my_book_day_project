package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IHabitJpaMapper {
    
    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "category.user", ignore = true)
    Habit toHabit(HabitEntity habitEntity);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "category.user", ignore = true)
    HabitEntity toHabitEntity(Habit habit);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "category.user", ignore = true)
    List<Habit> toHabitsList(List<HabitEntity> lstHabitEntities);
}
