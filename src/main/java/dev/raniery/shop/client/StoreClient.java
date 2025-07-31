package dev.raniery.shop.client;

import dev.raniery.shop.client.response.StoreProductResponse;
import dev.raniery.shop.exceptions.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "PlatziStoreClient", url = "${shop.client.platzi}", configuration = {CustomErrorDecoder.class})
public interface StoreClient {

    @GetMapping("/products")
    List<StoreProductResponse> getProducts();

    @GetMapping("/products/{id}")
    StoreProductResponse getProductById(@PathVariable Long id);
}
