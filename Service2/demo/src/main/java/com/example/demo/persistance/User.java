package com.example.demo.persistance;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "app_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('app_user_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Constructeur par défaut nécessaire pour JPA
    public User() {
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role {
        ROLE_ADMIN,
        ROLE_NORMAL
    }

    // Implémentation des méthodes de UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convertir le rôle en un objet GrantedAuthority
        return Collections.singletonList(() -> role.name());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // l'account n'est pas expiré
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // l'account n'est pas verrouillé
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // les identifiants ne sont pas expirés
    }

    @Override
    public boolean isEnabled() {
        return true;  // l'utilisateur est activé
    }
}
