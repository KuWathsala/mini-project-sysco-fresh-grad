package com.syscolabs.miniproject.utils;

import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Product;

import java.util.List;

public interface ICustomMapper {

    ProductSummaryDto mapProductDtoToProductSummaryDto(Product product);
    List<ProductSummaryDto> mapProductDtosToProductSummaryDtos(List<Product> productList);
    Product mapProductSummaryDtoToProduct(ProductSummaryDto productSummaryDto);
}
