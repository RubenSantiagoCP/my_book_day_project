package com.app.mydaybook.activities.infrastructure.adapters.input.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mydaybook.activities.application.service.impl.CategoryQueryService;
import com.app.mydaybook.activities.domain.model.Category;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.data.response.CategoryResponse;
import com.app.mydaybook.activities.infrastructure.adapters.input.rest.mapper.ICategortRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryQueryController {
    
    private final CategoryQueryService categoryQueryService;

    private final ICategortRestMapper categoryRestMapper;

    @GetMapping("/allCategories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<Category> categories = categoryQueryService.getAllCategories();
        return ResponseEntity.ok(categoryRestMapper.toCategoryResponseList(categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id){
        Category category = categoryQueryService.getCategoryById(id);
        return ResponseEntity.ok(categoryRestMapper.toCategoryResponse(category));
    }
}
