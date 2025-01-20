package com.app.mydaybook.activities.application.ports.input;

import java.util.List;

import com.app.mydaybook.activities.domain.model.Habit;

public interface IHabitQueryPort {
    public Habit getHabitById(Long id);
    public List<Habit> getAllHabits();
}
