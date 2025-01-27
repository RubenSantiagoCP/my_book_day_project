package com.app.mydaybook.activities.infrastructure.adapters.input.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.activities.application.service.impl.HabitQueryService;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.GetByDateRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.HabitResponse;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper.IHabitRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/habit")
public class HabitQueryController {
    
    private final HabitQueryService habitQueryService;
    private final IHabitRestMapper habitRestMapper;

    @GetMapping("/allHabitsUser/{id}")
    public ResponseEntity<List<HabitResponse>> getHabitsByUser(@PathVariable Long id){
        List<Habit> habits = habitQueryService.getHabitsByUserId(id);
        return ResponseEntity.ok(habitRestMapper.toHabitResponseList(habits));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitResponse> getHabitById(@PathVariable Long id){
        Habit habit = habitQueryService.getHabitById(id);
        return ResponseEntity.ok(habitRestMapper.toHabitResponse(habit));
    }

    @GetMapping("/allHabitsDate")
    public ResponseEntity<List<HabitResponse>> getHabitsByDate(@RequestBody GetByDateRequest getByDateRequest){
        List<Habit> habits = habitQueryService.getHabitsByDate(
            getByDateRequest.getUserId(), 
            getByDateRequest.getDate());
        return ResponseEntity.ok(habitRestMapper.toHabitResponseList(habits));
    }

    
}
