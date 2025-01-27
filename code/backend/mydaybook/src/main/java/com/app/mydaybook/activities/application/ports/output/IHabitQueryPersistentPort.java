package com.app.mydaybook.activities.application.ports.output;

import java.time.LocalDate;
import java.util.List;

import com.app.mydaybook.activities.domain.model.Habit;

public interface IHabitQueryPersistentPort {
    public Habit getHabitById(Long id);
    public List<Habit> getHabitsByUserId(Long id);
    public List<Habit> getHabitsByDate(Long userId, LocalDate date);
    public boolean existedConflictByName(String name, Long userId);
}
