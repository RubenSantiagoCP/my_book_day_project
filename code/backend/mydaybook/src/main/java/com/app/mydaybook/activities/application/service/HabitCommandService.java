package com.app.mydaybook.activities.application.service;


import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.IHabitCommandPort;
import com.app.mydaybook.activities.application.ports.output.IHabitCommandPersistentPort;
import com.app.mydaybook.activities.domain.enums.HabitFrequency;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitCommandService implements IHabitCommandPort {

    private final IHabitCommandPersistentPort habitCommandPersistentPort;
    private final ExceptionManager exceptionManager;

    @Override
    public Habit createHabit(Habit habit) {
        validateEndDate(habit);
        validateCategory(habit);
        validateFrecuency(habit);
        return habitCommandPersistentPort.createHabit(habit);
    }

    @Override
    public Habit updateHabit(Long id, Habit habit) {
        validateEndDate(habit);
        validateCategory(habit);
        validateFrecuency(habit);
        return habitCommandPersistentPort.updateHabit(id, habit);
    }

    @Override
    public boolean deleteHabit(Long id) {
        return habitCommandPersistentPort.deleteHabit(id);
    }



    private void validateEndDate(Habit habit) {
        // Set default values for endDate
        if (habit.getEndDate() == null) {
            throw exceptionManager.createException(ErrorCode.HABIT_END_DATE_REQUIRED);
        }

        if (habit.getEndDate().isBefore(habit.getStartDate())) {
            throw exceptionManager.createException(ErrorCode.END_DATE_BEFORE_START_DATE);

        }
    }

    private void validateFrecuency(Habit habit) {
        // Set default values for frecuency
        if (habit.getFrequency() == null) {
            habit.setFrequency(HabitFrequency.DAILY);
        }
    }

    private void validateCategory(Habit habit) {
        if(habit.getCategory()==null){
            Category category = new Category();
            category.setId(1L);
            habit.setCategory(category);
        }
    }

}
