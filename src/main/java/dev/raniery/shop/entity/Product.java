package dev.raniery.shop.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Product {

    private Long id;
    private String title;
    private BigDecimal price;
    private String[] images;
    private Integer quantity;
}
