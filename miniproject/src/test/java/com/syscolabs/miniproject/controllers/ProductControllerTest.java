package com.syscolabs.miniproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syscolabs.miniproject.Dtos.CategoryDto;
import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Product;
import com.syscolabs.miniproject.services.IProductService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @MockBean
    private IProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    void setUp() {
    }

    @Test
    public void testGetAllCategories () throws Exception{

        List<ProductSummaryDto> productSummaryDtos = new ArrayList<>();
        productSummaryDtos.add(new ProductSummaryDto(1, "product1", 10, 50,  "https://imgurl1.com", "Category 1", 1));
        productSummaryDtos.add(new ProductSummaryDto(2, "product2", 20, 60,  "https://imgurl2.com", "Category 2", 2));
        productSummaryDtos.add(new ProductSummaryDto(3, "product1", 30, 70,  "https://imgurl3.com", "Category 3", 3));

        when(productService.getAllProducts()).thenReturn(productSummaryDtos);

        mockMvc.perform(get("/mini-project-api/products").
                        contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));

    }

    @Test
    public void addNewProductTest() throws Exception {

        ProductSummaryDto newProductSummaryDto = new ProductSummaryDto(0, "product1", 10, 50,  "https://imgurl1.com", "Category 1", 1);

        mockMvc.perform( post("/mini-project-api/products")
                        .content(asJsonString(newProductSummaryDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void getProductsByNameTest() throws Exception {

        List<ProductSummaryDto> productSummaryDtos = new ArrayList<>();
        productSummaryDtos.add(new ProductSummaryDto(1, "product1", 10, 50,  "https://imgurl1.com", "Category 1", 1));
        productSummaryDtos.add(new ProductSummaryDto(2, "product2", 20, 60,  "https://imgurl2.com", "Category 2", 2));
        productSummaryDtos.add(new ProductSummaryDto(3, "product1", 30, 70,  "https://imgurl3.com", "Category 3", 3));

        when(productService.getProductsByName("pro")).thenReturn(productSummaryDtos);

        mockMvc.perform(get("/mini-project-api/products/search-product/{product_name}", "pro")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            System.out.println("err");
            throw new RuntimeException(e);
        }
    }

}
