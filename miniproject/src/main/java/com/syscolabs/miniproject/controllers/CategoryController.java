package com.syscolabs.miniproject.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syscolabs.miniproject.Dtos.CategoryDto;
import com.syscolabs.miniproject.services.ICategoryService;
import com.syscolabs.miniproject.utils.ResponseHandler;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/mini-project-api/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewCategory(@RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto categoryDtos = categoryService.addNewCategory(categoryDto);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }

    @GetMapping()
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ResponseEntity<?> getAllCategories() {
        List<CategoryDto> categoryDtos = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }
}

