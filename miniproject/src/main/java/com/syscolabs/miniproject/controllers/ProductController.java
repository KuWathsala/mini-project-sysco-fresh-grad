package com.syscolabs.miniproject.controllers;

import com.syscolabs.miniproject.Dtos.ProductDto;
import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Producer;
import com.syscolabs.miniproject.services.IProductService;
import com.syscolabs.miniproject.utils.ResponseHandler;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Validated
@CrossOrigin("http://localhost:3000")
@RequestMapping("/mini-project-api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public ResponseEntity<?> getAllProducts() {
        List<ProductSummaryDto> productSummaryDtos = this.productService.getAllProducts();
        return new ResponseEntity<List<ProductSummaryDto>>(productSummaryDtos, HttpStatus.OK);
    }

    @GetMapping("search-product/{product_name}")
    public  ResponseEntity<?> getProductsByName(@PathVariable @Valid String product_name) {
        List<ProductSummaryDto> productSummaryDtos = this.productService.getProductsByName(product_name);
        return new ResponseEntity<List<ProductSummaryDto>>(productSummaryDtos, HttpStatus.OK);
    }
}
