package dev.raniery.shop.controller.doc;

import dev.raniery.shop.entity.Basket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Basket", description = "CRUD Operations related to the shopping basket")
public interface BasketControllerInterface {

    @Operation(
        summary = "Get Basket by ID",
        description = "Retrieve a shopping basket by its unique identifier."
    )
    ResponseEntity<Basket> getBasketById(@PathVariable String id);
}
