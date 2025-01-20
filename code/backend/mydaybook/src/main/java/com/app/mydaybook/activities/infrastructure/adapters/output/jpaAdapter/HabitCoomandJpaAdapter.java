package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.IHabitCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.IHabitJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.IHabitRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HabitCoomandJpaAdapter implements IHabitCommandPersistentPort {
    
    private final IHabitRepository habitRepository;
    private final IHabitJpaMapper habitJpaMapper;

    @Override
    public Habit createHabit(Habit habit) {
        HabitEntity habitEntity = habitJpaMapper.toHabitEntity(habit);
        habitEntity = habitRepository.save(habitEntity);
        return habitJpaMapper.toHabit(habitEntity); 
    }

    @Override
    public Habit updateHabit(Long id, Habit habit) {
        HabitEntity habitEntity = habitRepository.findById(id).orElseThrow();
        habitEntity = habitRepository.save(habitEntity);
        return habitJpaMapper.toHabit(habitEntity);
    }

    @Override
    public boolean deleteHabit(Long id) {
        HabitEntity habitEntity = habitRepository.findById(id).orElseThrow();
        if(habitEntity!=null){
            habitRepository.delete(habitEntity);
            return true;
        }
        return false;
    }
    
}
