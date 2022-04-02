package com.syscolabs.miniproject.Dtos;

import com.syscolabs.miniproject.entities.Product;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CategoryDto {
    @NonNull
    @Size(min = 2, message = "{category.notempty}")
    private String name;

    @NonNull
    @URL(message = "{imgURL.notValid}")
    private String imgURL;

    private List<Product> products;
}
