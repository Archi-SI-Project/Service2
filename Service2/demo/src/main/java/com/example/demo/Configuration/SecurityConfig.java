package com.example.demo.Configuration;

import com.example.demo.Service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Pour utiliser @PreAuthorize, etc.
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    // Injection du CustomUserDetailsService
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users").permitAll() // Permet l'accès à /users sans authentification
                        .requestMatchers("/public/**").permitAll() // exemple d'URL publique
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()) // ou .formLogin() selon ton besoin
                .userDetailsService(customUserDetailsService)  // Ajoute ton UserDetailsService
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
}
