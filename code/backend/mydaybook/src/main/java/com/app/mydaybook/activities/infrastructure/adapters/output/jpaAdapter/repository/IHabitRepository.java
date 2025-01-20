package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;

public interface IHabitRepository extends JpaRepository<HabitEntity, Long> {
    
}
