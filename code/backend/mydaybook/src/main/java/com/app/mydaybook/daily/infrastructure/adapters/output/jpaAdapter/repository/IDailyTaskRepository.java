package com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.mydaybook.daily.infrastructure.adapters.output.jpaAdapter.entity.DailyTaskEntity;

public interface IDailyTaskRepository extends JpaRepository<DailyTaskEntity, Long> {
    @Query("SELECT dt FROM DailyTaskEntity dt WHERE dt.date = :date AND dt.user.id = :userId AND dt.task.id = :taskId")
    DailyTaskEntity findByDateAndUserIdAndTaskId(@Param("date") LocalDate date, @Param("userId") Long userId,
            @Param("taskId") Long taskId);

}
