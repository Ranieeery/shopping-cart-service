package dev.raniery.shop.controller.doc;

import dev.raniery.shop.entity.request.AuthenticationRequest;
import dev.raniery.shop.entity.request.RegisterRequest;
import dev.raniery.shop.entity.response.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Authentication", description = "Endpoints related to user authentication and registration")
public interface AuthControllerInterface {

    @Operation(
        summary = "User Login",
        description = "Authenticate a user and return a JWT token upon successful login."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login successful"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<LoginResponse> login(@RequestBody @Valid AuthenticationRequest data);

    @Operation(
        summary = "User Registration",
        description = "Register a new user with the provided credentials and role."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Registration successful"),
        @ApiResponse(responseCode = "400", description = "Invalid registration data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest data);
}
