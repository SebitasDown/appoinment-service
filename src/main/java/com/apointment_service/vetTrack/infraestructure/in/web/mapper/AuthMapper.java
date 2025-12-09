package com.apointment_service.vetTrack.infraestructure.in.web.mapper;

import com.apointment_service.vetTrack.application.port.in.comman.AuthCommand;
import com.apointment_service.vetTrack.application.port.in.comman.AuthenticationResponse;
import com.apointment_service.vetTrack.application.port.in.comman.RegisterCommand;
import com.apointment_service.vetTrack.domain.model.User;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.request.AuthRequest;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.request.RegisterRequest;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.AuthResponse;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    // Request → Command (entrada)
    RegisterCommand toRegisterCommand(RegisterRequest request);

    AuthCommand toAuthCommand(AuthRequest request);

    // Domain → Response (salida)
    UserResponse toUserResponse(User user);

    AuthResponse toAuthResponse(AuthenticationResponse authenticationResponse);
}
