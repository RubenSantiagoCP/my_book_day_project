package com.app.mydaybook.activities.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.IHabitQueryPort;
import com.app.mydaybook.activities.application.ports.output.IHabitQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Habit;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitQueryService implements IHabitQueryPort{
    
    private final IHabitQueryPersistentPort habitQueryPersistentPort;

    @Override
    public Habit getHabitById(Long id) {
        return habitQueryPersistentPort.getHabitById(id);
    }

    @Override
    public List<Habit> getHabitsByUserId(Long id) {
        return habitQueryPersistentPort.getHabitsByUserId(id);
    }

    @Override
    public List<Habit> getHabitsByDate(Long userId, LocalDate date) {
        return habitQueryPersistentPort.getHabitsByDate(userId, date);
    }

    
}
