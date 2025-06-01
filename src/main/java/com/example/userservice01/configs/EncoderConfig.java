package com.example.userservice01.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncoderConfig {
    // This class is used to configure the password encoder for the application.
    // It uses BCryptPasswordEncoder to hash passwords securely.

    // The password encoder bean is defined here, which can be injected wherever needed.
    // The @Bean annotation indicates that this method returns a bean that should be managed by the Spring container.

    @Bean
     public BCryptPasswordEncoder getBCryptPasswordEncoder() {
         return new BCryptPasswordEncoder();
     }
}
