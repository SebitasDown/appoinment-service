package com.apointment_service.vetTrack.application.port.in;

import com.apointment_service.vetTrack.domain.model.User;

import java.util.Optional;

public interface GetUserByUsernameUseCase {
    Optional<User> getUserByUsername(String username);
}
