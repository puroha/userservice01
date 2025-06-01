package com.example.userservice01.dtos;

import com.example.userservice01.models.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String tokenValue;
    private Long expireAt;
    private String userName;
    private String roleName;

    public static LoginResponseDto fromToken(Token token) {
        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setTokenValue(token.getValue());
        responseDto.setExpireAt(token.getExpireAt());
        responseDto.setUserName(token.getUser().getName());
        responseDto.setRoleName(token.getUser().getRoles().get(0).getName()); // Assuming the first role is the primary one
        return responseDto;
    }
}
