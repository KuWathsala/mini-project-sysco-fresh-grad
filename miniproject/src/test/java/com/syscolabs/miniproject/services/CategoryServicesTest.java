package com.syscolabs.miniproject.services;

import com.syscolabs.miniproject.Dtos.CategoryDto;
import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Product;
import com.syscolabs.miniproject.repositories.CategoryRepository;
import com.syscolabs.miniproject.utils.CustomMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServicesTest {

    @Spy
    ModelMapper mapper;

    @Spy
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @Test
    public void testGetAllCategories() {

        List<Category> categoryList = new ArrayList<>();

        categoryList.add(new Category(
                "name1",
                "https://img1.com",
                new ArrayList<Product>()
        ));
        categoryList.add(new Category(
                "name2",
                "https://img1.com",
                new ArrayList<Product>()
        ));

        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<CategoryDto> result = categoryService.getAllCategories();

        assertEquals(2, result.size());

    }

    @Test
    public void testAddNewCategory() {

        CategoryDto categoryDto = new CategoryDto(
                "category",
                "https://img1.com",
                null
        );

        ModelMapper mapper = new ModelMapper();
        Category newCategory = mapper.map(categoryDto, Category.class);
        when(categoryRepository.save(newCategory)).thenReturn(newCategory);

        CategoryDto result = categoryService.addNewCategory(categoryDto);

        assertEquals(categoryDto, result);
    }

}
