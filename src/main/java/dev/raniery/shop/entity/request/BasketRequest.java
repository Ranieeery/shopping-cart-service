package dev.raniery.shop.entity.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BasketRequest(

    @NotNull
    Long clientId,

    @Valid
    @NotNull
    List<ProductsRequest> products) {
}
