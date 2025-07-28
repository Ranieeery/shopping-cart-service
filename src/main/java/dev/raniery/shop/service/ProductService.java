package dev.raniery.shop.service;

import dev.raniery.shop.client.StoreClient;
import dev.raniery.shop.client.response.StoreProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final StoreClient storeClient;

    @Cacheable(value = "products")
    public List<StoreProductResponse> getProducts() {
        log.info("Getting products");
        return storeClient.getProducts();
    }

    @Cacheable(value = "product", key = "#id")
    public StoreProductResponse getProductsById(Long id) {
        log.info("Getting product with id: {}", id);
        return storeClient.getProductById(id);
    }
}
