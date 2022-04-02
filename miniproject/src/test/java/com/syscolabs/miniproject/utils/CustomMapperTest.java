package com.syscolabs.miniproject.utils;

import com.syscolabs.miniproject.Dtos.ProductDto;
import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Producer;
import com.syscolabs.miniproject.entities.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomMapperTest {

    @Test
    public void testMapProductsToProductSummaryDtos() {

        Product product1 = new Product(
                1,
                "product 1",
                10,
                50,
                "https://www.imgurl1.com",
                new Category("Category 1", "https://www.img1category.com", null),
                new Producer(1, "producer1", "+94711234567", null)
        );


        Product product2 = new Product(
                2,
                "product 2",
                20,
                60,
                "https://www.imgurl2.com",
                new Category("Category 2", "https://www.img1category.com", null),
                new Producer(2, "producer1", "+94711234567", null)
        );

        List<ProductSummaryDto> productSummaryDtos = new ArrayList<>();
        productSummaryDtos.add(new ProductSummaryDto(1, "product 1", 10, 50,  "https://www.imgurl1.com", "Category 1", 1));
        productSummaryDtos.add(new ProductSummaryDto(2, "product 2", 20, 60,  "https://www.imgurl2.com", "Category 2", 2));


        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        CustomMapper customMapper = new CustomMapper();
        List<ProductSummaryDto> productSummaryDtoTest =  customMapper.mapProductsToProductSummaryDtos(productList);

        assertEquals(productSummaryDtos, productSummaryDtoTest);
    }

    @Test
    public void testMapProductToProductSummaryDto() {

        Product product= new Product(
                1,
                "product 1",
                10, 100,
                "https://www.imgproduct1.com",
                new Category("category1", "https://www.img1category.com", null),
                new Producer(1, "producer1", "+94711234567", null)
        );

        CustomMapper customMapper = new CustomMapper();
        ProductSummaryDto productSummaryDto =  customMapper.mapProductToProductSummaryDto(product);

        assertEquals(product.getId(), productSummaryDto.getId());
        assertEquals(product.getName(), productSummaryDto.getName());
        assertEquals(product.getImgURL(), productSummaryDto.getImgURL());
        assertEquals(product.getCategory().getName(), productSummaryDto.getCategoryName());
        assertEquals(product.getProducer().getId(), productSummaryDto.getProducerId(), 0.0);

    }

}
