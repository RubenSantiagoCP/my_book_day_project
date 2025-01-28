package com.app.mydaybook.daily.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.daily.application.service.impl.DailyRecordQueryService;
import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.request.NotesDailyRequest;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.response.NotesDailyResponse;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.mapper.IDailyRecordRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/daily/note")
@RequiredArgsConstructor
public class DailyRecordQueryController {
    
    private final DailyRecordQueryService dailyRecordQueryService;
    private final IDailyRecordRestMapper dailyRecordRestMapper;

    @GetMapping("/get")
    public ResponseEntity<NotesDailyResponse> getNotesDaily(@RequestBody NotesDailyRequest notesDailyRequest) { 
        DailyRecord dailyRecord = dailyRecordQueryService.getDailyRecordByDate(notesDailyRequest.getDate(), notesDailyRequest.getUserId());
        return ResponseEntity.ok(dailyRecordRestMapper.toNotesDailyResponse(dailyRecord));
    }
}
