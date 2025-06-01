package com.example.userservice01.repos;


import com.example.userservice01.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    // JpaRepository provides methods for CRUD operations
    // No need to implement any methods here
    Role findByName(String name);
}
