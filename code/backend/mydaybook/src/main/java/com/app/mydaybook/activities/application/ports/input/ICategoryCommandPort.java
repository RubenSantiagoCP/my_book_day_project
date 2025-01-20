package com.app.mydaybook.activities.application.ports.input;

import com.app.mydaybook.activities.domain.model.Category;

public interface ICategoryCommandPort {
    public Category createCategory(Category category);
    public Category updateCategory(Long id, Category category);
    public boolean deleteCategory(Long id);
}
