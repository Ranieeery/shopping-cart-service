package dev.raniery.shop.entity.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BasketRequest(

    @NotNull(message = "clientId cannot be null")
    @Schema(
        description = "Client ID",
        example = "1",
        requiredMode = Schema.RequiredMode.REQUIRED)
    Long clientId,

    @Valid
    @NotNull(message = "Products cannot be null, must be at least one")
    @Schema(
        description = "List of products in the basket",
        requiredMode = Schema.RequiredMode.REQUIRED)
    List<ProductsRequest> products) {
}
