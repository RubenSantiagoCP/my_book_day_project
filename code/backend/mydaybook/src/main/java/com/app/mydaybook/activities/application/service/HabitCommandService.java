package com.app.mydaybook.activities.application.service;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.IHabitCommandPort;
import com.app.mydaybook.activities.application.ports.output.IHabitCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Habit;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitCommandService implements IHabitCommandPort{

    private final IHabitCommandPersistentPort habitCommandPersistentPort;

    @Override
    public Habit createHabit(Habit habit) {
       return habitCommandPersistentPort.createHabit(habit);
    }

    @Override
    public Habit updateHabit(Long id, Habit habit) {
        return habitCommandPersistentPort.updateHabit(id, habit);
    }

    @Override
    public boolean deleteHabit(Long id) {
        return habitCommandPersistentPort.deleteHabit(id);
    }
    
}
