package com.jersson.arrivasplata.swtvap.api.web.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.web.business.service.CategoryService;
import com.jersson.arrivasplata.swtvap.api.web.expose.CategoryController;
import com.jersson.arrivasplata.swtvap.api.web.mapper.CategoryMapper;
import com.jersson.arrivasplata.swtvap.api.web.model.CategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/w-categories", produces = "application/vnd.swtvap-api-w-category.v1+json")
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;


    public CategoryControllerImpl(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CategoryResponse> getAllCategories() {
       return Flux.fromIterable(categoryService.getAllCategories())
                .map(category -> {
                    CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);
                    return categoryResponse;
                });
    }

    // Implementa otros métodos del controlador si es necesario
}