package com.app.mydaybook.activities.application.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.IHabitQueryPort;
import com.app.mydaybook.activities.application.ports.output.IHabitQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.user.application.service.UserValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitQueryService implements IHabitQueryPort{
    
    private final IHabitQueryPersistentPort habitQueryPersistentPort;
    private final UserValidationService userValidationService;

    @Override
    public Habit getHabitById(Long id) {
        return habitQueryPersistentPort.getHabitById(id);
    }

    @Override
    public List<Habit> getHabitsByUserId(Long id) {
        userValidationService.validateUserExists(id);
        return habitQueryPersistentPort.getHabitsByUserId(id);
    }

    @Override
    public List<Habit> getHabitsByDate(Long userId, LocalDate date) {
        userValidationService.validateUserExists(userId);
        return habitQueryPersistentPort.getHabitsByDate(userId, date);
    }

    
}
