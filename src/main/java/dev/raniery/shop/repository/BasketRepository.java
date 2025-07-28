package dev.raniery.shop.repository;

import dev.raniery.shop.entity.Basket;
import dev.raniery.shop.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {
    Optional<Basket> findByClientAndStatus(Long client, Status status);
}
