package com.apointment_service.vetTrack.application.port.out;

import com.apointment_service.vetTrack.domain.model.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(String name);
}
