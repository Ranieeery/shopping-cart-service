package dev.raniery.shop.client.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.math.BigDecimal;

public record StoreProductResponse(

    @Schema(
        description = "Unique identifier of the product",
        example = "1"
    )
    Long id,

    @Schema(
        description = "Title of the product",
        example = "Wireless Headphones"
    )
    String title,

    @Schema(
        description = "Description of the product",
        example = "High-quality wireless headphones with noise cancellation."
    )
    BigDecimal price,

    @Schema(
        description = "Array of image URLs for the product",
        example = "[\"https://example.com/image1.jpg\", \"https://example.com/image2.jpg\"]"
    )
    String[] images) implements Serializable {
}
