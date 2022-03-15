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
    public ProductSummaryDto addProduct(ProductSummaryDto productSummaryDto){
        return null;
    }

    @Override
    public List<ProductSummaryDto> getAllProducts() {
        List<Product> productList = this.productRepository.findAll();
        List<ProductSummaryDto> productSummaryDtos = customMapper.mapProductDtosToProductSummaryDtos(productList);
        return productSummaryDtos;
    }

    @Override
    public ProductSummaryDto getProductById(long id) {
        Product product = this.productRepository.getById(id);
        ProductSummaryDto productSummaryDto = customMapper.mapProductDtoToProductSummaryDto(product);
        return productSummaryDto;
    }

    @Override
    public List<ProductSummaryDto> getProductsByName(String productName) {
        List<Product> products = this.productRepository.findByNameContaining(productName);
        List<ProductSummaryDto> productSummaryDtos = customMapper.mapProductDtosToProductSummaryDtos(products);
        return productSummaryDtos;
    }

//        @Override
//    public ProductSummaryDto getProductByName(String productName) {
//        Product product = this.productRepository.findByName(productName);
//        ProductSummaryDto productSummaryDto = customMapper.mapProductDtoToProductSummaryDto(product);
//        return productSummaryDto;
//    }

//        @Override
//    public List<ProductDto> getAllProducts() {
//
//        List<Product> productList = this.productRepository.findAll();
//
//        List<ProductDto> productDtos = productList
//                .stream()
//                .map(x -> mapper.map(x, ProductDto.class))
//                .collect(Collectors.toList());
//
//        return productDtos;
//    }

}
