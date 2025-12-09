package com.apointment_service.vetTrack.application.port.in;

import com.apointment_service.vetTrack.domain.model.User;

public interface CreateUserUseCase {
    User createUser(String username, String password);
}
