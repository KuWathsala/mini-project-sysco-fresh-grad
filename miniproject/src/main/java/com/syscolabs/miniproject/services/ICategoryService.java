package com.syscolabs.miniproject.services;

import com.syscolabs.miniproject.Dtos.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    CategoryDto addNewCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
}
