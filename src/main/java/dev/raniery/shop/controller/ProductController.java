package dev.raniery.shop.controller;

import dev.raniery.shop.client.response.StoreProductResponse;
import dev.raniery.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<StoreProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductsById(id));
    }
}
