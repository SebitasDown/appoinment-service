package com.apointment_service.vetTrack.infraestructure.in.web.controller;

import com.apointment_service.vetTrack.application.port.in.AuthenticateUserUseCase;
import com.apointment_service.vetTrack.application.port.in.CreateUserUseCase;
import com.apointment_service.vetTrack.application.port.in.comman.AuthCommand;
import com.apointment_service.vetTrack.application.port.in.comman.AuthenticationResponse;
import com.apointment_service.vetTrack.application.port.in.comman.RegisterCommand;
import com.apointment_service.vetTrack.domain.model.User;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.request.AuthRequest;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.request.RegisterRequest;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.AuthResponse;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.UserResponse;
import com.apointment_service.vetTrack.infraestructure.in.web.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CreateUserUseCase createUserUseCase;
    private final AuthenticateUserUseCase authenticateUseCase;
    private final AuthMapper authMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        // Request → Command
        RegisterCommand command = authMapper.toRegisterCommand(request);


        User user = createUserUseCase.createUser(command);

        // Domain → Response
        return ResponseEntity.ok(authMapper.toUserResponse(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // Request → Command
        AuthCommand command = authMapper.toAuthCommand(request);

        // Ejecutar caso de uso
        AuthenticationResponse authResponse = authenticateUseCase.authenticate(command);

        // Response domain → Response DTO
        return ResponseEntity.ok(authMapper.toAuthResponse(authResponse));
    }
}
