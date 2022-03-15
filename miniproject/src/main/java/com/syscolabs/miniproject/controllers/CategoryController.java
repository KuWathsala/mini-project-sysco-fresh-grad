package com.syscolabs.miniproject.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syscolabs.miniproject.Dtos.CategoryDto;
import com.syscolabs.miniproject.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mini-project-api/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtos = categoryService.getAllCategories();
        return categoryDtos;
    }

}
