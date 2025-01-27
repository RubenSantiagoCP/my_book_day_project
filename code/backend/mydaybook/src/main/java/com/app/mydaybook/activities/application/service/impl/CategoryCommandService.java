package com.app.mydaybook.activities.application.service.impl;


import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.ICategoryCommandPort;
import com.app.mydaybook.activities.application.ports.output.ICategoryCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryCommandService implements ICategoryCommandPort {

    private final ICategoryCommandPersistentPort categoryCommandPersistentPort;
    @Override
    public Category createCategory(Category category) {
        return categoryCommandPersistentPort.createCategory(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return categoryCommandPersistentPort.updateCategory(id, category);
    }

    @Override
    public boolean deleteCategory(Long id) {
        return categoryCommandPersistentPort.deleteCategory(id);
    }
    
}
