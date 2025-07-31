package dev.raniery.shop.controller.doc;

import dev.raniery.shop.client.response.StoreProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Product", description = "Operations related to products from the store")
public interface ProductControllerInterface {

    @Operation(
        summary = "Get all products",
        description = "Retrieve a list of all available products from the store."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<StoreProductResponse>> getProducts();

    @Operation(
        summary = "Get product by ID",
        description = "Retrieve a specific product by its unique identifier."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product found successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<StoreProductResponse> getProductById(@PathVariable Long id);
}
