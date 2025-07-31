package dev.raniery.shop.controller.doc;

import dev.raniery.shop.entity.Basket;
import dev.raniery.shop.entity.request.BasketRequest;
import dev.raniery.shop.entity.request.PaymentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Basket", description = "CRUD Operations related to the shopping basket")
public interface BasketControllerInterface {

    @Operation(
        summary = "Get Basket by ID",
        description = "Retrieve a shopping basket by its unique identifier."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Basket found successfully"),
        @ApiResponse(responseCode = "404", description = "Basket not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Basket> getBasketById(@PathVariable String id);

    @Operation(
        summary = "Create new basket",
        description = "Create a new shopping basket with the provided information."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Basket created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Basket> createBasket(@Valid @RequestBody BasketRequest request);

    @Operation(
        summary = "Update existing basket",
        description = "Update an existing shopping basket with new information."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Basket updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request data"),
        @ApiResponse(responseCode = "404", description = "Basket not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Basket> updateBasket(@PathVariable String id, @Valid @RequestBody BasketRequest request);

    @Operation(
        summary = "Process basket payment",
        description = "Process payment for a shopping basket and update its status."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment processed successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid payment data"),
        @ApiResponse(responseCode = "404", description = "Basket not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Basket> payBasket(@PathVariable String id, @Valid @RequestBody PaymentRequest request);

    @Operation(
        summary = "Delete basket",
        description = "Delete a shopping basket by its unique identifier."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Basket deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Basket not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> deleteBasket(@PathVariable String id);
}
