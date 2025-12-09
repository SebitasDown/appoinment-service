package com.apointment_service.vetTrack.domain.model;

import com.apointment_service.vetTrack.domain.exception.RoleInvalidException;

public class Role {

    private Long id;
    private String name; // Roles

    public Role(String name) {
        if (name == null || name.isBlank()) {
            throw new RoleInvalidException("El nombre del rol es obligatorio");
        }
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
