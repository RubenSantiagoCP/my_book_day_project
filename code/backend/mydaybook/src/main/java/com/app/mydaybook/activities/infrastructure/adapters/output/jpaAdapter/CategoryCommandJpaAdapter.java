package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;


import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.ICategoryCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.ICategoryJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryCommandJpaAdapter implements ICategoryCommandPersistentPort {

    private final ICategoryJpaMapper categoryJpaMapper;

    private final ICategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        CategoryEntity categoryEntity = categoryJpaMapper.toCategoryEntity(category);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryJpaMapper.toCategory(categoryEntity);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow();
        if(categoryEntity!=null){
            categoryEntity.setDescription(category.getDescription());
            categoryEntity.setName(category.getName());
            return categoryJpaMapper.toCategory(categoryEntity);
        }

        throw new IllegalArgumentException("Category does not exists");
    }

    @Override
    public boolean deleteCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow();
        if(categoryEntity!=null){
            categoryRepository.delete(categoryEntity);
            return true;
        }
        return false;

    }
    
}
