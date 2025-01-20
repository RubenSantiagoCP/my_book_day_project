package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.ICategoryQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.ICategoryJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryQueryJpaAdapter implements ICategoryQueryPersistentPort {
    private final ICategoryJpaMapper categoryJpaMapper;

    private final ICategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow();
        if(categoryEntity!=null){
            return categoryJpaMapper.toCategory(categoryEntity);
        }

        throw new IllegalArgumentException("Category does not exists");
    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> lstCategoryEntities = categoryRepository.findAll();
        return categoryJpaMapper.toCategoryList(lstCategoryEntities);
    }
    
}
