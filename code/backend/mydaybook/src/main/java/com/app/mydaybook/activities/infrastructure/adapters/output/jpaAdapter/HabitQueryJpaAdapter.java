package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.IHabitQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Habit;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.IHabitJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.IHabitRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HabitQueryJpaAdapter implements IHabitQueryPersistentPort{
    
    private final IHabitRepository habitRepository;
    private final IHabitJpaMapper habitJpaMapper;
    @Override
    public Habit getHabitById(Long id) {
        HabitEntity habitEntity = habitRepository.findById(id).orElseThrow();
        return habitJpaMapper.toHabit(habitEntity);
    }

    @Override
    public List<Habit> getAllHabits() {
        List<HabitEntity> lstHabitEntities = habitRepository.findAll();
        return habitJpaMapper.toHabitsList(lstHabitEntities);
    }
    
}
