package com.example.userservice01.security.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import com.example.userservice01.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String name;
    private String hashedPassword;
    private String email;
    private Long dob;
    private Long createdAt;
    private boolean isEmailVerified;
    private Long id;
    private String phoneNumber;
    private List<CustomGrantedAuthority> grantedAuthorities;

    public CustomUserDetails(User user) {
        this.name = user.getName();
        this.hashedPassword = user.getHashedPassword();
        this.email = user.getEmail();
        this.dob = user.getDob();
        this.createdAt = user.getCreatedAt();
        this.isEmailVerified = user.isEmailVerified();
        this.id = user.getId();
        this.phoneNumber = user.getPhones() != null && !user.getPhones().isEmpty() ? user.getPhones().get(0).getPhoneNumber() : null;
        this.grantedAuthorities = user.getRoles() != null ? user.getRoles().stream()
                .map(CustomGrantedAuthority::new)
                .toList() : List.of();

    }

    public CustomUserDetails() {
        // Default constructor for serialization/deserialization
        this.name = "";
        this.hashedPassword = "";
        this.email = "";
        this.dob = 0L;
        this.createdAt = 0L;
        this.isEmailVerified = false;
        this.id = 0L;
        this.phoneNumber = "";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return getHashedPassword();
    }

    @Override
    public String getUsername() {
        return "";
    }
}
