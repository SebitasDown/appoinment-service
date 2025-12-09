package com.apointment_service.vetTrack.application.port.out;

import com.apointment_service.vetTrack.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByUsername(String username);
    boolean existByUsername(String username);
}
