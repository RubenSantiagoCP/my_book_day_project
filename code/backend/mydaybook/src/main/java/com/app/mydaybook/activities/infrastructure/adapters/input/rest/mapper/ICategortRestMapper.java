package com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.CategoryRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.CategoryResponse;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategortRestMapper {
    
    @Mapping(target = "user.id", source = "userId")
    Category toCategory(CategoryRequest categoryRequest);

    @Mapping(target = "userId", source = "user.id")
    CategoryResponse toCategoryResponse(Category category);

    @Mapping(target = "userId", source = "user.id")
    List<CategoryResponse> toCategoryResponseList(List<Category> categories);
}
