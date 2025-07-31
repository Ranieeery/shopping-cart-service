package dev.raniery.shop.entity.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductsRequest(

    @NotNull
    Long id,

    @Min(1)
    @NotNull
    Integer quantity) {
}
