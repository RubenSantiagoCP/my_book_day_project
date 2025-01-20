package com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.HabitRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.HabitResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IHabitRestMapper {

    @Mapping(target = "category.id", source = "categoryId")
    Habit toHabit(HabitRequest habitRequest);

    HabitRequest toHabitRequest(Habit habit);

    HabitResponse toHabitResponse(Habit habit);

    List<HabitResponse> toHabitResponseList(List<Habit> habits);
    
}
