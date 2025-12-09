package com.apointment_service.vetTrack.application.port.in;

import com.apointment_service.vetTrack.domain.model.Role;

import java.util.Optional;

public interface FindRoleById {
    Optional<Role> findByName(String name);
}
