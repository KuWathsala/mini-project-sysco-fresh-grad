package com.syscolabs.miniproject.Dtos;

import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDtoTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void when_category_entity_to_category_dto_then_correct() {

        CategoryDto categoryDto = new CategoryDto(
                "name2",
                "https://img1.com",
                new ArrayList<Product>()
        );

        Category category  = modelMapper.map(categoryDto, Category.class);

        assertEquals(categoryDto.getName(), category.getName());
        assertEquals(categoryDto.getImgURL(), category.getImgURL());
        assertEquals(categoryDto.getProducts(), category.getProducts());
    }

    @Test
    public void when_category_dto_to_category_entity_then_correct() {

        Category category = new Category(
                "name2",
                "https://img1.com",
                new ArrayList<Product>()
        );

        CategoryDto categoryDto  = modelMapper.map(category, CategoryDto.class);

        assertEquals(category.getName(), categoryDto.getName());
        assertEquals(category.getImgURL(), categoryDto.getImgURL());
        assertEquals(category.getProducts(), categoryDto.getProducts());
    }

}
