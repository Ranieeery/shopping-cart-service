package dev.raniery.shop.entity.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductsRequest(

    @NotNull(message = "Product ID cannot be null")
    @Schema(
        description = "ID of the product to be added to the order",
        example = "15",
        requiredMode = Schema.RequiredMode.REQUIRED)
    Long id,

    @Min(value = 1, message = "Quantity must be at least 1")
    @NotNull(message = "Quantity cannot be null and must be at least 1")
    @Schema(
        description = "Quantity of the product to be added to the order",
        example = "2",
        requiredMode = Schema.RequiredMode.REQUIRED)
    Integer quantity) {
}
