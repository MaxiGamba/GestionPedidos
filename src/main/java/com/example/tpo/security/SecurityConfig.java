package com.example.tpo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable()) // Disable CORS
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll() // Permit access to all requests without authentication
            )
            .httpBasic(httpBasic -> httpBasic.disable()) // Disable HTTP basic authentication
            .formLogin(formLogin -> formLogin.disable()) // Disable form-based authentication
            .oauth2Login(oauth2Login -> oauth2Login.disable()); // Disable OAuth2 login
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}