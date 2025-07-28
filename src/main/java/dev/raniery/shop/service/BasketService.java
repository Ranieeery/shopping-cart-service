package dev.raniery.shop.service;

import dev.raniery.shop.client.response.StoreProductResponse;
import dev.raniery.shop.entity.Basket;
import dev.raniery.shop.entity.Product;
import dev.raniery.shop.entity.Status;
import dev.raniery.shop.entity.request.BasketRequest;
import dev.raniery.shop.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    public Basket createBasket(BasketRequest basketRequest) {

        basketRepository.findByClientAndStatus(basketRequest.clientId(), Status.OPEN)
            .ifPresent(basket -> {
                throw new IllegalArgumentException("Basket already exists for this client");
            });

        List<Product> products = new ArrayList<>();

        basketRequest.products().forEach(productRequest -> {
            StoreProductResponse productResponse = productService.getProductsById(productRequest.id());

            products.add(Product.builder()
                .id(productResponse.id())
                .title(productResponse.title())
                .price(productResponse.price())
                .quantity(productRequest.quantity())
                .images(productResponse.images())
                .build());
        });

        Basket basket = Basket.builder()
            .client(basketRequest.clientId())
            .status(Status.OPEN)
            .products(products)
            .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }
}
