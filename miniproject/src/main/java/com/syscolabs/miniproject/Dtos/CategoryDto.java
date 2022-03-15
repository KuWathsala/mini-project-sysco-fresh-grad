package com.syscolabs.miniproject.Dtos;

import com.syscolabs.miniproject.entities.Product;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class CategoryDto {
    private String name;
    private List<Product> products;
}
