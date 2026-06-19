package dev.raniery.shop.entity.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(

    @Schema(
        description = "JWT token for authentication",
        example = "eyJhbGciOi"
    )
    String token) {
}
