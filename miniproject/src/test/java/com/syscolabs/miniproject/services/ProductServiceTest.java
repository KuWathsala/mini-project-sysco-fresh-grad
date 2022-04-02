package com.syscolabs.miniproject.services;

import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Producer;
import com.syscolabs.miniproject.entities.Product;
import com.syscolabs.miniproject.repositories.ProductRepository;
import com.syscolabs.miniproject.utils.CustomMapper;
import com.syscolabs.miniproject.utils.ICustomMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    @Spy
    ICustomMapper customMapper;
    @Spy
    ProductRepository productRepository;
    @Spy
    ModelMapper mapper;

    @InjectMocks
    private ProductService productService;

    List<Product> productList = new ArrayList<>();

    @Before
    public void setUp() {
        productList.add(new Product(1,
                "product1",
                10,
                50,
                "https://imgurl1.com",
                new Category("cat1", "https://imgurl1.com", new ArrayList<Product>()),
                new Producer(1, "p1", "+94711234567", new ArrayList<Product>())));

        productList.add(new Product(
                2, "product2",
                20,
                60,
                "https://imgurl2.com",
                new Category("cat2", "https://imgurl2.com", new ArrayList<Product>()),
                new Producer(1, "p1", "+94711234567", new ArrayList<Product>())));
    }


    @Test
    public void testGetAllProducts () {

        when(productRepository.findAll()).thenReturn(productList);
        CustomMapper cMapper = new CustomMapper();
        when(customMapper.mapProductsToProductSummaryDtos(productList)).thenReturn(cMapper.mapProductsToProductSummaryDtos(productList));

        List<ProductSummaryDto> result = productService.getAllProducts();

        assertEquals(2, result.size());

    }

    @Test
    public void testGetProductsByName () {

        when(this.productRepository.findByNameContaining("product")).thenReturn(productList);
        CustomMapper cMapper = new CustomMapper();
        when(customMapper.mapProductsToProductSummaryDtos(productList)).thenReturn(cMapper.mapProductsToProductSummaryDtos(productList));

        List<ProductSummaryDto> result = productService.getProductsByName("product");

        assertEquals(2, result.size());

    }

}
