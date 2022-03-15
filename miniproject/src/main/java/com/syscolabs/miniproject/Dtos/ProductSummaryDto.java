package com.syscolabs.miniproject.Dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductSummaryDto {
    private long id;
    private String name;
    private int qty;
    private double price;
    private String imgURL;
    private double producerId;
}
