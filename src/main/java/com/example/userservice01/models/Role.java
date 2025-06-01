package com.example.userservice01.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Role extends BaseModel{
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private Permission permission;
}
