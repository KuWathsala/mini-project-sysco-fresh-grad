package com.syscolabs.miniproject.Dtos;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductSummaryDto {

    private long id;

    @NonNull
    @Size(min = 2, message = "{product.notempty}")
    private String name;

    @NonNull
    @Min(value = 0, message = "{qty.notempty}")
    @Max(value = Integer.MAX_VALUE)
    private int qty;

    @NonNull
    @DecimalMin(value = "0.0", message = "{price.notvalid}")
    @Digits(integer=2, fraction=2, message = "{price.notvalid}")
    private double price;

    @NonNull
    @URL(message = "{imgURL.notValid}")
    private String imgURL;

    @NonNull
    @Size(min = 2, message = "{category.required}")
    private String categoryName;

    @NonNull
    @Min(value = 1, message = "{producer.notempty}")
    private double producerId;
}
