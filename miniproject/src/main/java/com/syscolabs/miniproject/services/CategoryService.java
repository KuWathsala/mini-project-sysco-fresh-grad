package com.syscolabs.miniproject.services;

import com.syscolabs.miniproject.Dtos.CategoryDto;
import com.syscolabs.miniproject.Dtos.ProductDto;
import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Product;
import com.syscolabs.miniproject.repositories.CategoryRepository;
import com.syscolabs.miniproject.utils.CustomMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto addNewCategory(CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        this.categoryRepository.save(category);
        CategoryDto createdCategoryDto = mapper.map(category, CategoryDto.class);
        return createdCategoryDto;
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categoryList = this.categoryRepository.findAll();

        List<CategoryDto> categoryDtos = categoryList
                .stream()
                .map(x -> mapper.map(x, CategoryDto.class))
                .collect(Collectors.toList());

        return categoryDtos;
    }

}
