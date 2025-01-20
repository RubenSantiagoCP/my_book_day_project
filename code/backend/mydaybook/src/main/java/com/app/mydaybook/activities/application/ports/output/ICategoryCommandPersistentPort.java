package com.app.mydaybook.activities.application.ports.output;

import com.app.mydaybook.activities.domain.model.Category;

public interface ICategoryCommandPersistentPort {
    public Category createCategory(Category category);
    public Category updateCategory(Long id, Category category);
    public boolean deleteCategory(Long id);
}
