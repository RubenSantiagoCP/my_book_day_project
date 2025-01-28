package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.TaskEntity;

public interface ITaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query("SELECT t FROM TaskEntity t WHERE t.user.id = :userId AND :date BETWEEN t.startDate AND t.endDate")
    List<TaskEntity> findTasksByUserIdAndDate(
            @Param("userId") Long userId,
            @Param("date") LocalDateTime date);

    @Query("SELECT COUNT(t) > 0 FROM TaskEntity t " +
            "WHERE t.user.id = :userId " +
            "AND t.title = :title " +
            "AND ((t.startDate <= :endDate AND t.endDate >= :startDate))")
    boolean existsConflictByUserAndTitleAndDateRange(
            @Param("userId") Long userId,
            @Param("title") String title,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);

    List<TaskEntity> findByUserId(Long userId);
}
