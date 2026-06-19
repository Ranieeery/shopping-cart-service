package dev.raniery.shop.controller;

import dev.raniery.shop.entity.Users;
import dev.raniery.shop.entity.request.AuthenticationRequest;
import dev.raniery.shop.entity.request.RegisterRequest;
import dev.raniery.shop.entity.response.LoginResponse;
import dev.raniery.shop.repository.UserRepository;
import dev.raniery.shop.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
//TODO: mover lógica para o service
//TODO: doc
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid AuthenticationRequest data) {
        var user = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(user);

        var credentials = tokenService.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(credentials));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest data) {
        if (userRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users user = new Users(data.login(), encryptedPassword, data.role());

        userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}

