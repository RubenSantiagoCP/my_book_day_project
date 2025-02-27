package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.ICategoryQueryPersistentPort;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.ICategoryJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ICategoryRepository;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryQueryJpaAdapter implements ICategoryQueryPersistentPort {
    private final ICategoryJpaMapper categoryJpaMapper;

    private final ICategoryRepository categoryRepository;
    private final ExceptionManager exceptionManager;

    @Override
    public Category getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.CATEGORY_NOT_FOUND));
        return categoryJpaMapper.toCategory(categoryEntity);

    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> lstCategoryEntities = categoryRepository.findAll();
        return categoryJpaMapper.toCategoryList(lstCategoryEntities);
    }

    @Override
    public boolean existedConflictByName(String name, Long userId) {
        return categoryRepository.existedConflictByName( userId, name);
    }

    @Override
    public boolean existedCategoryByUser(Long userId, Long categoryId) {
        return categoryRepository.existedCategoryByUser(userId, categoryId);
    }

}
