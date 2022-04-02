package com.syscolabs.miniproject.Dtos;

import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Producer;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductDto {

    private long id;
    private String name;
    private int qty;
    private double price;
    private String imgURL;
    private Category category;
    private Producer producer;

}
