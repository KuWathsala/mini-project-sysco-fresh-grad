package com.syscolabs.miniproject.Dtos;

import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Producer;
import com.syscolabs.miniproject.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDtoTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void when_product_entity_to_product_dto_then_correct() {

        ProductDto productDto = new ProductDto(
                1,
                "product1",
                10,
                50.00,
                "https://imgurl1.com",
                new Category("cat1", "https://imgurl1.com", new ArrayList<Product>()),
                new Producer(1, "p1", "+94711234567", new ArrayList<Product>()));

        Product product  = modelMapper.map(productDto, Product.class);

        assertEquals(productDto.getId(), product.getId());
        assertEquals(productDto.getName(), product.getName());
        assertEquals(productDto.getQty(), product.getQty());
        assertEquals(productDto.getPrice(), product.getPrice(), 0);
        assertEquals(productDto.getImgURL(), product.getImgURL());
        assertEquals(productDto.getCategory(), product.getCategory());
        assertEquals(productDto.getProducer(), product.getProducer());
    }

    @Test
    public void when_product_dto_to_category_product_then_correct() {

        Product product = new Product(
                1,
                "product1",
                10,
                50.00,
                "https://imgurl1.com",
                new Category("cat1", "https://imgurl1.com", new ArrayList<Product>()),
                new Producer(1, "p1", "+94711234567", new ArrayList<Product>()));

        ProductDto productDto  = modelMapper.map(product, ProductDto.class);

        assertEquals(product.getId(), productDto.getId());
        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getQty(), productDto.getQty());
        assertEquals(product.getPrice(), productDto.getPrice(), 0);
        assertEquals(product.getImgURL(), productDto.getImgURL());
        assertEquals(product.getCategory(), productDto.getCategory());
        assertEquals(product.getProducer(), productDto.getProducer());

    }

}
