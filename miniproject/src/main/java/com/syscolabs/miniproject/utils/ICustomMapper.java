package com.syscolabs.miniproject.utils;

import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Product;

import java.util.List;

public interface ICustomMapper {
    ProductSummaryDto mapProductToProductSummaryDto(Product product);
    List<ProductSummaryDto> mapProductsToProductSummaryDtos(List<Product> productList);
}
