package com.app.mydaybook.activities.application.ports.output;

import java.util.List;

import com.app.mydaybook.activities.domain.model.Habit;

public interface IHabitQueryPersistentPort {
    public Habit getHabitById(Long id);
    public List<Habit> getAllHabits();
}
