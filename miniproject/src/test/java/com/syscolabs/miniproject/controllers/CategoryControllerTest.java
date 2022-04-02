package com.syscolabs.miniproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syscolabs.miniproject.Dtos.CategoryDto;
import com.syscolabs.miniproject.entities.Product;
import com.syscolabs.miniproject.repositories.CategoryRepository;
import com.syscolabs.miniproject.services.CategoryService;
import com.syscolabs.miniproject.services.ICategoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @MockBean
    private ICategoryService categoryService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    void setUp() {
    }

    @Test
    public void testGetAllCategories () throws Exception{
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryDtos.add(new CategoryDto("a", "https://imgurl1.com", new ArrayList<Product>()));
        categoryDtos.add(new CategoryDto("b", "https://imgurl1.com", new ArrayList<Product>()));
        categoryDtos.add(new CategoryDto("c", "https://imgurl1.com", new ArrayList<Product>()));

        when(categoryService.getAllCategories()).thenReturn(categoryDtos);

        mockMvc.perform(get("/mini-project-api/categories").
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    public void testAddNewCategory () throws Exception  {
        CategoryDto newCategoryDto = new CategoryDto();
        newCategoryDto.setName("Caregory 1");
        newCategoryDto.setImgURL("https://www.img.com");

        mockMvc.perform( post("/mini-project-api/categories")
                        .content(asJsonString(newCategoryDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"name\":\"Caregory 1\",\"imgURL\":\"https://www.img.com\",\"products\":null}"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
