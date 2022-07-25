package com.example.SpringServer.repositories;


import java.util.Optional;

import com.example.SpringServer.model.ERole;
import com.example.SpringServer.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
