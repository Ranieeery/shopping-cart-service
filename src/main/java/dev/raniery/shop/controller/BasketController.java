package dev.raniery.shop.controller;

import dev.raniery.shop.entity.Basket;
import dev.raniery.shop.entity.request.BasketRequest;
import dev.raniery.shop.entity.request.PaymentRequest;
import dev.raniery.shop.service.BasketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable String id) {
        return ResponseEntity.ok(basketService.getBasketById(id));
    }

    @PostMapping
    public ResponseEntity<Basket> createBasket(@Valid @RequestBody BasketRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.createBasket(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable String id, @Valid @RequestBody BasketRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(basketService.updateBasket(id, request));
    }

    @PatchMapping("/{id}/payment")
    public ResponseEntity<Basket> payBasket(@PathVariable String id, @Valid @RequestBody PaymentRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(basketService.updatePaymentBasket(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasket(@PathVariable String id) {
        basketService.deleteBasket(id);
        return ResponseEntity.noContent().build();
    }
}
