package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.IHabitCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.IHabitJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ICategoryRepository;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.IHabitRepository;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HabitCommandJpaAdapter implements IHabitCommandPersistentPort {

    private final IHabitRepository habitRepository;
    private final ICategoryRepository categoryRepository;

    private final IHabitJpaMapper habitJpaMapper;

    private final ExceptionManager exceptionManager;

    @Override
    public Habit createHabit(Habit habit) {
        if (habit.getCategory() != null) {
            CategoryEntity categoryEntity = verifiedCategoryExists(habit.getCategory().getId());
            HabitEntity habitEntity = habitJpaMapper.toHabitEntity(habit);
            habitEntity.setCategory(categoryEntity);
            try {
                habitEntity = habitRepository.save(habitEntity);
                return habitJpaMapper.toHabit(habitEntity);
            } catch (DataIntegrityViolationException ex) {
                throw exceptionManager.createException(ErrorCode.HABIT_ALREADY_EXISTS);
            }

        } else {
            throw exceptionManager.createException(ErrorCode.HABIT_CATEGORY_OBLIGATORY);
        }

    }

    @Override
    public Habit updateHabit(Long id, Habit habit) {
        HabitEntity habitEntity = habitRepository.findById(id)
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.HABIT_NOT_FOUND));

        if (habit.getCategory() != null) {
            CategoryEntity categoryEntity = verifiedCategoryExists(habit.getCategory().getId());
            if (categoryEntity != null) {
                habitEntity.setCategory(categoryEntity);
                habitEntity.setDescription(habit.getDescription());
                habitEntity.setEndDate(habit.getEndDate());
                habitEntity.setFrequency(habit.getFrequency());
                habitEntity.setName(habit.getName());
                habitEntity.setStartDate(habit.getStartDate());
                try {
                    habitEntity = habitRepository.save(habitEntity);
                    return habitJpaMapper.toHabit(habitEntity);
                } catch (DataIntegrityViolationException ex) {
                    throw exceptionManager.createException(ErrorCode.HABIT_ALREADY_EXISTS);
                }
            } else {
                throw exceptionManager.createException(ErrorCode.HABIT_CATEGORY_OBLIGATORY);
            }
        }
        throw new IllegalArgumentException("Category does not exist");
    }

    @Override
    public boolean deleteHabit(Long id) {
        HabitEntity habitEntity = habitRepository.findById(id)
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.HABIT_NOT_FOUND));
        habitRepository.delete(habitEntity);
        return true;

    }

    private CategoryEntity verifiedCategoryExists(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.CATEGORY_NOT_FOUND));
        return categoryEntity;
    }

}
