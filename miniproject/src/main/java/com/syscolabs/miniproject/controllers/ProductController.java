package com.syscolabs.miniproject.controllers;

import com.syscolabs.miniproject.Dtos.ProductDto;
import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mini-project-api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public List<ProductSummaryDto> getAllProducts() {
        List<ProductSummaryDto> productSummaryDtos = this.productService.getAllProducts();
        return productSummaryDtos;
    }

//    @PostMapping()
//    public void add(@RequestBody ProductDto productDto) {
//        return;
//    }

    @GetMapping("/{id}")
    ProductSummaryDto getProductById(@PathVariable String id) {
        long longId;
        try {
            longId = Long.parseLong(id);
        }
        catch ( NumberFormatException e) {
            return null;
        }
        ProductSummaryDto productSummaryDto = this.productService.getProductById(longId);
        return productSummaryDto;
    }

    @GetMapping("search-product/{product_name}")
    List<ProductSummaryDto> getProductsByName(@PathVariable String product_name) {
        return this.productService.getProductsByName(product_name);
    }

}
