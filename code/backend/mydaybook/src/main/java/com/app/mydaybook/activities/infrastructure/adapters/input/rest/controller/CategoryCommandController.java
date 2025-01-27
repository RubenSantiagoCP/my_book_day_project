package com.app.mydaybook.activities.infrastructure.adapters.input.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.activities.application.service.impl.CategoryCommandService;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.request.CategoryRequest;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.CategoryResponse;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper.ICategortRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryCommandController {
    
    private final CategoryCommandService categoryCommandService;

    private final ICategortRestMapper categoryRestMapper;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest ) {
        Category category = categoryRestMapper.toCategory(categoryRequest);
        category = categoryCommandService.createCategory(category);
        return ResponseEntity.ok(categoryRestMapper.toCategoryResponse(category));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@RequestBody CategoryRequest categoryRequest, @PathVariable Long id) {
        Category category = categoryRestMapper.toCategory(categoryRequest);
        category = categoryCommandService.updateCategory(id, category);
        return ResponseEntity.ok(categoryRestMapper.toCategoryResponse(category));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Long id) {
        Boolean response = categoryCommandService.deleteCategory(id);
        return ResponseEntity.ok().body(response);
    }
}
