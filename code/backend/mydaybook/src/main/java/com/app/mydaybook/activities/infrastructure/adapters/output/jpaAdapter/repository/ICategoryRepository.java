package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    
    @Query("SELECT COUNT(c) > 0 FROM CategoryEntity c " +
            "WHERE c.user.id = :userId " +
            "AND c.name = :name ")
    boolean existedConflictByName(
        @Param("userId") Long userId,
        @Param("name") String name
    );

    @Query("SELECT COUNT(c) > 0 FROM CategoryEntity c " +
    "WHERE c.user.id = :userId " +
    "AND c.id = :categoryId ")
    boolean existedCategoryByUser(
        @Param("userId") Long userId,
        @Param("categoryId") Long categoryId
    );
}
