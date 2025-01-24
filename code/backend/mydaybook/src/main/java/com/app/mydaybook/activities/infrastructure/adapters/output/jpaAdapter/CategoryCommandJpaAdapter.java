package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.app.mydaybook.activities.application.ports.output.ICategoryCommandPersistentPort;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper.ICategoryJpaMapper;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.repository.ICategoryRepository;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.entity.UserEntity;
import com.app.mydaybook.user.infrastructure.adapters.output.jpaAdapter.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryCommandJpaAdapter implements ICategoryCommandPersistentPort {

    private final ICategoryJpaMapper categoryJpaMapper;

    private final ICategoryRepository categoryRepository;

    private final ExceptionManager exceptionManager;

    private final IUserRepository userRepository;

    @Override
    public Category createCategory(Category category) {
        CategoryEntity categoryEntity = categoryJpaMapper.toCategoryEntity(category);
        if(category.getUser()!=null){
            UserEntity userEntity = userRepository.findById(categoryEntity.getUser().getId()).orElseThrow(()-> exceptionManager.createException(ErrorCode.USER_NOT_FOUND));
            categoryEntity.setUser(userEntity);
        }
        try {
            categoryEntity = categoryRepository.save(categoryEntity);
            return categoryJpaMapper.toCategory(categoryEntity);
        } catch (DataIntegrityViolationException ex) {
            throw exceptionManager.createException(ErrorCode.CATEGORY_ALREADY_EXISTS);
        }

    }

    @Override
    public Category updateCategory(Long id, Category category) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.CATEGORY_NOT_FOUND));
        if(categoryEntity.getUser()!=null){
            if(category.getUser().getId()!=categoryEntity.getUser().getId()){ 
                throw exceptionManager.createException(ErrorCode.USER_NOT_FOUND);
            }
        }
        categoryEntity.setDescription(category.getDescription());
        categoryEntity.setName(category.getName());
        try {
            categoryEntity = categoryRepository.save(categoryEntity);
            return categoryJpaMapper.toCategory(categoryEntity);
        } catch (DataIntegrityViolationException ex) {
            throw exceptionManager.createException(ErrorCode.CATEGORY_ALREADY_EXISTS);
        }
       
    }

    @Override
    public boolean deleteCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> exceptionManager.createException(ErrorCode.CATEGORY_NOT_FOUND));
        categoryRepository.delete(categoryEntity);
        return true;

    }

}
