package com.app.mydaybook.activities.application.ports.input;

import java.util.List;

import com.app.mydaybook.activities.domain.model.Category;

public interface ICategoryQueryPort {
    public Category getCategoryById(Long id);
    public List<Category> getAllCategories();
}
