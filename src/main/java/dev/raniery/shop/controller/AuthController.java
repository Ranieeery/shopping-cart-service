package dev.raniery.shop.controller;

import dev.raniery.shop.controller.doc.AuthControllerInterface;
import dev.raniery.shop.entity.request.AuthenticationRequest;
import dev.raniery.shop.entity.request.RegisterRequest;
import dev.raniery.shop.entity.response.LoginResponse;
import dev.raniery.shop.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerInterface {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid AuthenticationRequest data) {
        String login = authService.login(data.login(), data.password());

        return ResponseEntity.ok(new LoginResponse(login));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest data) {
        authService.register(data.login(), data.password(), data.role());

        return ResponseEntity.ok().build();
    }
}

