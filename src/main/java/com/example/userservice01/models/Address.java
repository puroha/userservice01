package com.example.userservice01.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address extends BaseModel {
    private String houseNumber;
    private String apartmentName;
    private String street;
    private String locality;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private boolean isDefault;

    // Default constructor for JPA
    public Address() {
    }
}
