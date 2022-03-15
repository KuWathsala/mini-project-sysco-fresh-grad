package com.syscolabs.miniproject.utils;

import com.syscolabs.miniproject.Dtos.ProductSummaryDto;
import com.syscolabs.miniproject.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomMapper implements ICustomMapper{

    @Autowired
    ModelMapper mapper;


    @Override
    public ProductSummaryDto mapProductDtoToProductSummaryDto(Product product) {
        ProductSummaryDto productSummaryDto = new ProductSummaryDto(
                product.getId(),
                product.getName(),
                product.getQty(),
                product.getPrice(),
                product.getImgURL(),
                product.getProducer().getId()
        );
        return productSummaryDto;
    }

    @Override
    public List<ProductSummaryDto> mapProductDtosToProductSummaryDtos(List<Product> productList) {
        List<ProductSummaryDto> roductSummaryDtoList = productList
                .stream()
                .map(x-> {
                    return new ProductSummaryDto(
                            x.getId(),
                            x.getName(),
                            x.getQty(),
                            x.getPrice(),
                            x.getImgURL(),
                            x.getProducer().getId()
                    );
                })
                .collect(Collectors.toList());

        return roductSummaryDtoList;
    }

    @Override
    public Product mapProductSummaryDtoToProduct(ProductSummaryDto productSummaryDto) {
        return null;
    }


}
