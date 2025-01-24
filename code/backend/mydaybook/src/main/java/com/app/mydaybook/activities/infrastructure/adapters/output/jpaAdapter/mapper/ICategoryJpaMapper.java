package com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.output.jpaAdapter.entity.CategoryEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryJpaMapper {
    
    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "habits", ignore = true)
    Category toCategory(CategoryEntity categoryEntity);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "habits", ignore = true)
    CategoryEntity toCategoryEntity(Category category);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "habits", ignore = true)
    List<Category> toCategoryList(List<CategoryEntity> lstCategoryEntities);

    @Mapping(target = "user.tasks", ignore = true)
    @Mapping(target = "user.habits", ignore = true)
    @Mapping(target = "user.categories", ignore = true)
    @Mapping(target = "habits", ignore = true)
    List<CategoryEntity> toCategoryEntities(List<Category> categories);
}
