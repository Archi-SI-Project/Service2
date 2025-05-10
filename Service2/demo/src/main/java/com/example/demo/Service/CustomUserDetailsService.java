package com.example.demo.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Exemple d'utilisateur avec mot de passe bcrypté
    private static final String USERNAME = "admin";
    private static final String PASSWORD_BCRYPT = "$2b$10$CwTycUXWue0Thq9StjUM0uJ8v6g9pM6S6zGm1Yc6Yp5fE/h0eF2b2"; // exemple bcrypté

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (USERNAME.equals(username)) {
            return User.builder()
                    .username(USERNAME)
                    .password(PASSWORD_BCRYPT)  // Le mot de passe bcrypté
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException("Utilisateur introuvable");
    }
}
