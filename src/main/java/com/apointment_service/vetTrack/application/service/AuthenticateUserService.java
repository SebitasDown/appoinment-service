package com.apointment_service.vetTrack.application.service;

import com.apointment_service.vetTrack.application.port.in.AuthenticateUserUseCase;
import com.apointment_service.vetTrack.application.port.in.comman.AuthCommand;
import com.apointment_service.vetTrack.application.port.in.comman.AuthenticationResponse;
import com.apointment_service.vetTrack.application.port.out.UserRepository;
import com.apointment_service.vetTrack.domain.model.Role;
import com.apointment_service.vetTrack.domain.model.User;
import com.apointment_service.vetTrack.infraestructure.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.stream.Collectors;

public class AuthenticateUserService implements AuthenticateUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthenticateUserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthenticationResponse authenticate(AuthCommand command) {
        // Buscar el usuario
        User user = userRepository.findByUsername(command.username())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        // Validar la contraseña
        if (!passwordEncoder.matches(command.password(), user.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Extraer los nombres de roles del usuario
        Set<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        // Generar el JWT token
        String token = jwtUtil.generateToken(user.getUsername(), roles);

        return new AuthenticationResponse(token);
    }
}