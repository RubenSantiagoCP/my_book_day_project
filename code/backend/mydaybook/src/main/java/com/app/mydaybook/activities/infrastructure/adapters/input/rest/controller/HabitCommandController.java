package com.app.mydaybook.activities.infrastructure.adapters.input.rest.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.activities.application.service.impl.HabitCommandService;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.HabitRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.HabitResponse;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper.IHabitRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/habit")
public class HabitCommandController {
    
    private final HabitCommandService habitCommandService;
    private final IHabitRestMapper habitRestMapper;

    @PostMapping("/create")
    public ResponseEntity<HabitResponse> createHabit(@RequestBody HabitRequest habitRequest){
        Habit habit = habitRestMapper.toHabit(habitRequest);
        habit = habitCommandService.createHabit(habit);
        return ResponseEntity.ok(habitRestMapper.toHabitResponse(habit));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<HabitResponse> updateHabit(@RequestBody HabitRequest habitRequest, @PathVariable Long id){
        Habit habit = habitRestMapper.toHabit(habitRequest);
        habit = habitCommandService.updateHabit(id, habit);
        return ResponseEntity.ok(habitRestMapper.toHabitResponse(habit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteHabit(@PathVariable Long id){
        Boolean response = habitCommandService.deleteHabit(id);
        return ResponseEntity.ok(response);
    }
    
}
