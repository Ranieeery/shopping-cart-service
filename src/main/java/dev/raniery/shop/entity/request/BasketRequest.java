package dev.raniery.shop.entity.request;

import java.util.List;

public record BasketRequest(
    Long clientId,
    List<ProductsRequest> products
) {
}
