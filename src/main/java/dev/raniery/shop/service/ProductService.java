package dev.raniery.shop.service;

import dev.raniery.shop.client.StoreClient;
import dev.raniery.shop.client.response.StoreProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final StoreClient storeClient;

    public List<StoreProductResponse> getProducts() {
        return storeClient.getProducts();
    }

    public StoreProductResponse getProductsById(Long id) {
        return storeClient.getProductById(id);
    }
}
