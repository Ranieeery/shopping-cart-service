package dev.raniery.shop.client.response;

import java.io.Serializable;
import java.math.BigDecimal;

public record StoreProductResponse(
    Long id,
    String title,
    BigDecimal price,
    String description,
    String[] images) implements Serializable {
}
