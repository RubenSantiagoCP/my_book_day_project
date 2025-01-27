package com.app.mydaybook.activities.application.service.impl;


import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.IHabitCommandPort;
import com.app.mydaybook.activities.application.ports.output.IHabitCommandPersistentPort;
import com.app.mydaybook.activities.application.service.validation.HabitConflictsValidation;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.domain.services.HabitValidator;
import com.app.mydaybook.user.application.service.UserValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitCommandService implements IHabitCommandPort {

    private final IHabitCommandPersistentPort habitCommandPersistentPort;
    private final UserValidationService userValidationService;
    private final HabitConflictsValidation habitConflictsValidation;

    private final HabitValidator habitValidator;


    @Override
    public Habit createHabit(Habit habit) {
        habitValidator.validateHabit(habit);
        userValidationService.validateUserExists(habit.getUserId());
        habitConflictsValidation.validateConflictName(habit.getName(), habit.getUserId());
        return habitCommandPersistentPort.createHabit(habit);
    }

    @Override
    public Habit updateHabit(Long id, Habit habit) {
        habitValidator.validateHabit(habit);
        userValidationService.validateUserExists(habit.getUserId());
        habitConflictsValidation.validateConflictName(habit.getName(), habit.getUserId());
        return habitCommandPersistentPort.updateHabit(id, habit);
    }

    @Override
    public boolean deleteHabit(Long id) {
        return habitCommandPersistentPort.deleteHabit(id);
    }



   

}
