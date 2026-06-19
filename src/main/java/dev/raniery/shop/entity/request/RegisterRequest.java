package dev.raniery.shop.entity.request;

import dev.raniery.shop.entity.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(

    @NotNull(message = "Login cannot be null")
    @Schema(
        description = "Login",
        example = "test_admin",
        requiredMode = Schema.RequiredMode.REQUIRED)
    String login,

    @NotNull(message = "Password cannot be null")
    @Schema(
        description = "Password",
        example = "test123456",
        requiredMode = Schema.RequiredMode.REQUIRED)
    String password,

    @NotNull(message = "Role cannot be null")
    @Schema(
        description = "User role",
        example = "admin",
        implementation = UserRole.class,
        requiredMode = Schema.RequiredMode.REQUIRED)
    UserRole role) {
}

