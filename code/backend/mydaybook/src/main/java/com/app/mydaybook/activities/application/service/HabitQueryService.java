package com.app.mydaybook.activities.application.service;

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
    public List<Habit> getAllHabits() {
        return habitQueryPersistentPort.getAllHabits();
    }

    
}
