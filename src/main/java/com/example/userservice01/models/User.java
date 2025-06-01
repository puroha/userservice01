package com.example.userservice01.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String name;
    private String hashedPassword;
    private String email;
    private Long dob;
    private Long createdAt;
    private boolean isEmailVerified;

    @ManyToMany
    private List<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Phone> phones;

    // Default constructor for JPA
    public User() {
    }

    // Getters and setters
}
