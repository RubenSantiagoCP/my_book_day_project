package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryJpaMapper {
    
    Category toCategory(CategoryEntity categoryEntity);

    CategoryEntity toCategoryEntity(Category category);
}
