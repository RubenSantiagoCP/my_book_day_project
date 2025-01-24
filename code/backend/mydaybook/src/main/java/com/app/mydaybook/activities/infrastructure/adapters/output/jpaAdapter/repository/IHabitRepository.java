package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.HabitEntity;

public interface IHabitRepository extends JpaRepository<HabitEntity, Long> {
    @Query("SELECT H FROM HabitEntity H WHERE H.user.id =: userId AND :date BETWEEN H.startDate AND H.endDate")
    public List<HabitEntity> findHabitByUserIdAndDate(Long userId, LocalDate date);

    List<HabitEntity> findByUserId(Long userId);
}
