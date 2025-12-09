package com.apointment_service.vetTrack.domain.model;

import com.apointment_service.vetTrack.domain.exception.UserInvalidException;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public User(String username, String password, Set<Role> roles) {
        if (username == null || username.isBlank()) {
            throw new UserInvalidException("El nombre de usuario es obligatorio");
        }
        if (password == null || password.isBlank()) {
            throw new UserInvalidException("La contraseña es obligatoria");
        }
        this.username = username;
        this.password = password;
        if (roles != null) {
            this.roles = roles;
        }
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        if (role != null) {
            roles.add(role);
        }
    }

    public boolean hasRole(String roleName) {
        return roles.stream().anyMatch(r -> r.getName().equals(roleName));
    }
}
