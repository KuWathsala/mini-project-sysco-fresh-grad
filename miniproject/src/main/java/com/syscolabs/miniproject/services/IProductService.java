package com.syscolabs.miniproject.services;

import com.syscolabs.miniproject.Dtos.ProductDto;
import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<ProductSummaryDto> getAllProducts();
    List<ProductSummaryDto> getProductsByName(String productName);
}
