package com.app.mydaybook.activities.application.ports.input;

import com.app.mydaybook.activities.domain.model.Habit;

public interface IHabitCommandPort {
    public Habit createHabit(Habit habit);
    public Habit updateHabit(Long id, Habit habit);
    public boolean deleteHabit(Long id);
}
