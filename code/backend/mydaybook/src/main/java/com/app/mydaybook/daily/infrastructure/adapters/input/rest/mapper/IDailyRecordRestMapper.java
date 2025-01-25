package com.app.mydaybook.daily.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.request.NotesDailyRequest;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.response.NotesDailyResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDailyRecordRestMapper {
    
    @Mapping(target = "user.id", source = "userId")
    DailyRecord toDailyRecord(NotesDailyRequest notesDailyRequest);

    @Mapping(target = "userId", source = "user.id")
    NotesDailyResponse toNotesDailyResponse(DailyRecord dailyRecord);
}
