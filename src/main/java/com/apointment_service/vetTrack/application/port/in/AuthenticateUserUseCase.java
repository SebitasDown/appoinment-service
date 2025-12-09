package com.apointment_service.vetTrack.application.port.in;

import com.apointment_service.vetTrack.application.port.in.comman.AuthCommand;
import com.apointment_service.vetTrack.application.port.in.comman.AuthenticationResponse;

public interface AuthenticateUserUseCase {
    AuthenticationResponse authenticate(AuthCommand command);
}
