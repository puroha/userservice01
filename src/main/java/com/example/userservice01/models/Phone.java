package com.example.userservice01.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Phone extends BaseModel {
    private String phoneNumber;
    private String type;
    private boolean isDefault;

    public Phone(String phoneNumber, String type) {
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    // Default constructor for JPA
    public Phone() {
    }
}
