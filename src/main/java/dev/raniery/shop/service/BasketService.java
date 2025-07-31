package dev.raniery.shop.service;

import dev.raniery.shop.client.response.StoreProductResponse;
import dev.raniery.shop.entity.Basket;
import dev.raniery.shop.entity.Product;
import dev.raniery.shop.entity.Status;
import dev.raniery.shop.entity.request.BasketRequest;
import dev.raniery.shop.entity.request.PaymentRequest;
import dev.raniery.shop.exceptions.BusinessException;
import dev.raniery.shop.exceptions.DataNotFoundException;
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

    public Basket getBasketById(String id) {
        return basketRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Basket with id " + id + " not found"));
    }

    public Basket createBasket(BasketRequest basketRequest) {

        basketRepository.findByClientAndStatus(basketRequest.clientId(), Status.OPEN)
            .ifPresent(basket -> {
                throw new BusinessException("Basket already exists for this client");
            });

        List<Product> products = getProducts(basketRequest);

        Basket basket = Basket.builder()
            .client(basketRequest.clientId())
            .status(Status.OPEN)
            .products(products)
            .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }

    public Basket updateBasket(String id, BasketRequest basketRequest) {
        Basket savedBasket = getBasketById(id);

        List<Product> products = getProducts(basketRequest);

        savedBasket.setProducts(products);

        savedBasket.calculateTotalPrice();

        return basketRepository.save(savedBasket);
    }

    public Basket updatePaymentBasket(String id, PaymentRequest request) {
        Basket savedBasket = getBasketById(id);

        savedBasket.setPaymentMethod(request.getPaymentMethod());
        savedBasket.setStatus(Status.SOLD);

        return basketRepository.save(savedBasket);
    }

    public void deleteBasket(String id) {
        Basket savedBasket = getBasketById(id);

        basketRepository.delete(savedBasket);
    }

    private List<Product> getProducts(BasketRequest basketRequest) {
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

        return products;
    }
}
