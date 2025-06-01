package com.example.userservice01.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    private String name;
    private String password;
    private String email;
    private Long dob;
}
