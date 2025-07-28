package dev.raniery.shop.client.response;

import java.math.BigDecimal;

public record StoreProductResponse(
    Long id,
    String title,
    BigDecimal price,
    String description,
    String[] images) {
}
