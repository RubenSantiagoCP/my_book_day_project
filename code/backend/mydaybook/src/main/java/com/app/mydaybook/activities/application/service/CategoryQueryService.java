package com.app.mydaybook.activities.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.input.ICategoryQueryPort;
import com.app.mydaybook.activities.application.ports.output.ICategoryQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryQueryService implements ICategoryQueryPort {
    
    private final ICategoryQueryPersistentPort categoryQueryPersistentPort;

    @Override
    public Category getCategoryById(Long id) {
        return categoryQueryPersistentPort.getCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryQueryPersistentPort.getAllCategories();
    }
}
