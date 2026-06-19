package dev.raniery.shop.service;

import dev.raniery.shop.entity.UserRole;
import dev.raniery.shop.entity.Users;
import dev.raniery.shop.infra.exceptions.RegisterException;
import dev.raniery.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public String login(String login, String password) {
        var user = new UsernamePasswordAuthenticationToken(login, password);
        var auth = authenticationManager.authenticate(user);

        var credentials = tokenService.generateToken((Users) auth.getPrincipal());

        return credentials;
    }

    public void register(String login, String password, UserRole role) {

        if (userRepository.findByLogin(login) != null) {
            throw new RegisterException("Login already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        Users user = new Users(login, encryptedPassword, role);

        userRepository.save(user);
    }
}
