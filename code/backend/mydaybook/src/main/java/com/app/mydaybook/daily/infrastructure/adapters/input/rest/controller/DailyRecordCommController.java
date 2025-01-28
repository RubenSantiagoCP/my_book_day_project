package com.app.mydaybook.daily.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.daily.application.service.impl.DailyRecordCommandService;
import com.app.mydaybook.daily.domain.model.DailyRecord;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.request.NotesDailyRequest;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.data.response.NotesDailyResponse;
import com.app.mydaybook.daily.infrastructure.adapters.input.rest.mapper.IDailyRecordRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/daily/note")
@RequiredArgsConstructor
public class DailyRecordCommController {
    
    private final DailyRecordCommandService dailyRecordCommandService;
    private final IDailyRecordRestMapper dailyRecordRestMapper;

    @PostMapping("/create")
    public ResponseEntity<NotesDailyResponse> createNotes(@RequestBody NotesDailyRequest notesDailyRequest) {
        DailyRecord dailyRecord = dailyRecordCommandService.createDailyRecord(dailyRecordRestMapper.toDailyRecord(notesDailyRequest));
        return ResponseEntity.ok(dailyRecordRestMapper.toNotesDailyResponse(dailyRecord));
    }

    @PostMapping("/update")
    public ResponseEntity<NotesDailyResponse> updateNotes(@RequestBody NotesDailyRequest notesDailyRequest) {
        DailyRecord dailyRecord = dailyRecordCommandService.updateDailyRecord(dailyRecordRestMapper.toDailyRecord(notesDailyRequest));
        return ResponseEntity.ok(dailyRecordRestMapper.toNotesDailyResponse(dailyRecord));
    }
}
