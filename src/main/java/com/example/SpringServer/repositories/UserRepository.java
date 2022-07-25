package com.example.SpringServer.repositories;

import com.example.SpringServer.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username); // optional&&&
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
