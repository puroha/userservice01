package com.example.userservice01.repos;

import com.example.userservice01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    // JpaRepository provides methods for CRUD operations
    // No need to implement any methods here

    boolean existsByEmail(String email);
    User findByEmail(String email);
}
