package com.syscolabs.miniproject.services;

import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Product;
import com.syscolabs.miniproject.repositories.ProductRepository;
import com.syscolabs.miniproject.utils.ICustomMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ICustomMapper customMapper;

    @Override
    public List<ProductSummaryDto> getAllProducts() {
        List<Product> productList = this.productRepository.findAll();
        List<ProductSummaryDto> productSummaryDtos = customMapper.mapProductsToProductSummaryDtos(productList);
        return productSummaryDtos;
    }

    @Override
    public List<ProductSummaryDto> getProductsByName(String productName) {
        List<Product> products = this.productRepository.findByNameContaining(productName);
        List<ProductSummaryDto> productSummaryDtos = customMapper.mapProductsToProductSummaryDtos(products);
        return productSummaryDtos;
    }

}
