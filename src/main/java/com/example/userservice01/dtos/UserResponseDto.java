package com.example.userservice01.dtos;

import com.example.userservice01.models.Role;
import com.example.userservice01.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDto {
    private String name;
    private String email;
    private List<Role> roles;

    public static UserResponseDto fromUser(User user) {
        UserResponseDto responseDto = new UserResponseDto();

        responseDto.setName(user.getName());
        responseDto.setEmail(user.getEmail());
        responseDto.setRoles(user.getRoles());

        return responseDto;
    }
}
