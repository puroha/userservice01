package com.example.userservice01.userservice;

import com.example.userservice01.dtos.LoginRequestDto;
import com.example.userservice01.dtos.SignUpRequestDto;
import com.example.userservice01.models.Permission;
import com.example.userservice01.models.Role;
import com.example.userservice01.models.Token;
import com.example.userservice01.models.User;
import com.example.userservice01.repos.RoleRepo;
import com.example.userservice01.repos.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
public class UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isEmailAlreadyRegistered(String email) {
        return userRepo.existsByEmail(email);
    }

    @Transactional
    public User signUp(SignUpRequestDto signUpRequestDto) {

        if (isEmailAlreadyRegistered(signUpRequestDto.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = new User();
        user.setEmail(signUpRequestDto.getEmail());
        user.setName(signUpRequestDto.getName());
        String password = passwordEncoder.encode(signUpRequestDto.getPassword());
        user.setHashedPassword(password);
        user.setDob(signUpRequestDto.getDob());
        user.setCreatedAt(System.currentTimeMillis());

        List<Role> roles = new ArrayList<>();
        Role role = roleRepo.findByName("USER");
        if (role == null) {
            role = new Role();
            role.setName("USER");
            role.setPermission(Permission.USER);
            role.setDescription("User role with basic permissions");
            role = roleRepo.save(role);
        }

        roles.add(role);
        user.setRoles(roles);

        userRepo.save(user);
        return user;
    }


    public Token login(LoginRequestDto loginDto) {
        Optional<User> user = userRepo.findByEmail(loginDto.getEmail());
        if (user.isEmpty()) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        // Check if the password matches

        // Check if the password matches
        if (!passwordEncoder.matches(loginDto.getPassword(), user.get().getHashedPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return getRandomToken(user.orElse(null));
    }

    private Token getRandomToken(User user) {
        Token token = new Token();
        token.setUser(user);
        token.setValue(UUID.randomUUID().toString()); // Replace with actual token generation logic
        token.setExpireAt(System.currentTimeMillis() + 3600000);
        return token;
    }
}
