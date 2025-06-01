package com.example.userservice01.controller;

import com.example.userservice01.dtos.LoginRequestDto;
import com.example.userservice01.dtos.LoginResponseDto;
import com.example.userservice01.dtos.SignUpRequestDto;
import com.example.userservice01.dtos.UserResponseDto;
import com.example.userservice01.models.Token;
import com.example.userservice01.models.User;
import com.example.userservice01.userservice.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        // Constructor logic if needed
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserResponseDto signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        // Logic to handle user sign-up
        User user = userService.signUp(signUpRequestDto);

        // Return the response DTO
        return UserResponseDto.fromUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginDto) {
        Token token = userService.login(loginDto);
        LoginResponseDto responseDto = LoginResponseDto.fromToken(token);
        return ResponseEntity.ok(responseDto);
    }

}
