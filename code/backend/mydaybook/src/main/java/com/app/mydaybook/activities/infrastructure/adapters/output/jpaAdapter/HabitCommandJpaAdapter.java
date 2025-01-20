package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.IHabitCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.IHabitJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ICategoryRepository;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.IHabitRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HabitCommandJpaAdapter implements IHabitCommandPersistentPort {

    private final IHabitRepository habitRepository;
    private final ICategoryRepository categoryRepository;

    private final IHabitJpaMapper habitJpaMapper;

    @Override
    public Habit createHabit(Habit habit) {
        if (habit.getCategory() != null) {
            CategoryEntity categoryEntity = verifiedCategoryExists(habit.getCategory().getId());
            if (categoryEntity != null) {
                HabitEntity habitEntity = habitJpaMapper.toHabitEntity(habit);
                habitEntity.setCategory(categoryEntity);
                habitEntity = habitRepository.save(habitEntity);
                return habitJpaMapper.toHabit(habitEntity);
            }
        }

        throw new IllegalArgumentException("Category does not exist");
    }

    @Override
    public Habit updateHabit(Long id, Habit habit) {
        HabitEntity habitEntity = habitRepository.findById(id).orElseThrow();
        if (habitEntity != null) {
            if (habit.getCategory() != null) {
                CategoryEntity categoryEntity = verifiedCategoryExists(habit.getCategory().getId());
                if (categoryEntity != null) {
                    habitEntity.setCategory(categoryEntity);
                    habitEntity.setDescription(habit.getDescription());
                    habitEntity.setEndDate(habit.getEndDate());
                    habitEntity.setFrequency(habit.getFrequency());
                    habitEntity.setName(habit.getName());
                    habitEntity.setStartDate(habit.getStartDate());
                    habitEntity = habitRepository.save(habitEntity);
                    return habitJpaMapper.toHabit(habitEntity);
                }
            }
        }
        throw new IllegalArgumentException("Category does not exist");
    }

    @Override
    public boolean deleteHabit(Long id) {
        HabitEntity habitEntity = habitRepository.findById(id).orElseThrow();
        if (habitEntity != null) {
            habitRepository.delete(habitEntity);
            return true;
        }
        return false;
    }

    private CategoryEntity verifiedCategoryExists(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow();
        if (categoryEntity == null) {
            throw new IllegalArgumentException("Category does not exist");
        }
        return categoryEntity;
    }

}
