package com.app.mydaybook.activities.application.service.impl;


import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.ICategoryCommandPort;
import com.app.mydaybook.activities.application.ports.output.ICategoryCommandPersistentPort;
import com.app.mydaybook.activities.application.service.validation.CategoryValidation;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.user.application.service.UserValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryCommandService implements ICategoryCommandPort {

    private final ICategoryCommandPersistentPort categoryCommandPersistentPort;
    private final UserValidationService userValidationService;
    private final CategoryValidation categoryConflictsValidation;
    @Override
    public Category createCategory(Category category) {
        userValidationService.validateUserExists(category.getUserId());
        return categoryCommandPersistentPort.createCategory(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        categoryConflictsValidation.existsCategoryByUser(category.getUserId(), id);
        return categoryCommandPersistentPort.updateCategory(id, category);
    }

    @Override
    public boolean deleteCategory(Long id) {
        return categoryCommandPersistentPort.deleteCategory(id);
    }
    
}
