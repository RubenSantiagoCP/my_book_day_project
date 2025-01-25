package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyRecordEntity;

public interface IDailyRecordRepository extends JpaRepository<DailyRecordEntity, Long> {
    
    public DailyRecordEntity findByDateAndUserId(LocalDate date, Long userId);
}
