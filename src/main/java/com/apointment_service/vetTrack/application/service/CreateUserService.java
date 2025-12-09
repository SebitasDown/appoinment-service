// CreateUserService.java
package com.apointment_service.vetTrack.application.service;

import com.apointment_service.vetTrack.application.port.in.CreateUserUseCase;
import com.apointment_service.vetTrack.application.port.in.comman.RegisterCommand;
import com.apointment_service.vetTrack.application.port.out.RoleRepository;
import com.apointment_service.vetTrack.application.port.out.UserRepository;
import com.apointment_service.vetTrack.domain.model.Role;
import com.apointment_service.vetTrack.domain.model.User;
import com.apointment_service.vetTrack.infraestructure.config.TransactionalUseCaseExecutor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

public class CreateUserService implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TransactionalUseCaseExecutor transactional;
    private final PasswordEncoder passwordEncoder;

    public CreateUserService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            TransactionalUseCaseExecutor transactional,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.transactional = transactional;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(RegisterCommand command) {
        return transactional.executeInTransaction(() -> {

            // Validar que el usuario no exista
            if (userRepository.existByUsername(command.username())) {
                throw new IllegalArgumentException("El usuario ya existe");
            }

            // Buscar el rol
            Role role = roleRepository.findByName(command.roleName())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

            // Encriptar la contraseña
            String encodedPassword = passwordEncoder.encode(command.password());

            // Crear y guardar el usuario
            User user = new User(command.username(), encodedPassword, Set.of(role));
            return userRepository.save(user);
        });
    }
}