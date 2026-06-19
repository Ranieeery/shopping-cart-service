package dev.raniery.shop.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import dev.raniery.shop.entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    private final long EXPIRATION_IN_MILLISECONDS = TimeUnit.DAYS.toMillis(30);

    public String generateToken(Users user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("auth-api")
                .withSubject(user.getUsername())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);

            return token;
        } catch (JWTCreationException e) {
            //TODO: Custom Exception
            throw new RuntimeException("Error generating token", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                .withIssuer("auth-api")
                .build()
                .verify(token)
                .getSubject();
        }catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant generateExpirationDate() {
        return Instant.now().plusMillis(EXPIRATION_IN_MILLISECONDS);
        // return LocalDateTime.now().plusDays(EXPIRATION_IN_MILLISECONDS).toInstant(ZoneOffset.of("-03:00"));
    }
}
