package com.app.mydaybook.activities.application.service.validation;

import org.springframework.stereotype.Service;

import com.app.mydaybook.activities.application.ports.output.ICategoryQueryPersistentPort;
import com.app.mydaybook.common.enums.exception.ErrorCode;
import com.app.mydaybook.common.exception.ExceptionManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryConflictsValidation {
    private final ICategoryQueryPersistentPort categoryQueryPersistentPort;
    private final ExceptionManager exceptionManager;

    public boolean existsConflictByName(String name, Long userId) {
        return categoryQueryPersistentPort.existedConflictByName(name, userId);
    }

    public void existsCategoryByUser(Long userId, Long categoryId) {
        if(!categoryQueryPersistentPort.existedCategoryByUser(userId, categoryId)){
            throw exceptionManager.createException(ErrorCode.CATEGORY_DOES_NOT_EXIST_FOR_USER);
        }
    }
}
