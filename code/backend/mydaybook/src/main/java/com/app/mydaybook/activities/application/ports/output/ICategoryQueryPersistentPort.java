package com.app.mydaybook.activities.application.ports.output;

import java.util.List;

import com.app.mydaybook.activities.domain.model.Category;

public interface ICategoryQueryPersistentPort {
    public Category getCategoryById(Long id);
    public List<Category> getAllCategories();
    public boolean existedConflictByName(String name, Long userId);
    public boolean existedCategoryByUser(Long userId, Long categoryId);
}
