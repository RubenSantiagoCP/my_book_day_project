package com.app.mydaybook.activities.domain.services;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.domain.enums.HabitFrequency;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitValidator {
    
    private final ExceptionManager exceptionManager;

    public void validateHabit(Habit habit) {
        validateEndDate(habit);
        validateCategory(habit);
        validateFrecuency(habit);
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
