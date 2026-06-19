package dev.raniery.shop.repository;

import dev.raniery.shop.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<Users, String> {
    UserDetails findByLogin(String login);
}
