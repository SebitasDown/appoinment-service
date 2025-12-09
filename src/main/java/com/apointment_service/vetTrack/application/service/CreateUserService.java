package com.apointment_service.vetTrack.application.service;

import com.apointment_service.vetTrack.application.port.in.CreateUserUseCase;
import com.apointment_service.vetTrack.application.port.out.RoleRepository;
import com.apointment_service.vetTrack.application.port.out.UserRepository;
import com.apointment_service.vetTrack.domain.model.Role;
import com.apointment_service.vetTrack.domain.model.User;
import com.apointment_service.vetTrack.infraestructure.config.TransactionalUseCaseExecutor;

import java.util.Set;

public class CreateUserService implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TransactionalUseCaseExecutor transactional;

    public CreateUserService(UserRepository userRepository, RoleRepository roleRepository, TransactionalUseCaseExecutor transactional) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.transactional = transactional;
    }

    @Override
    public User createUser(String username, String password, String roleName) {
        return transactional.executeInTransaction(() -> {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

            User user = new User(username, password, Set.of(role));
            return userRepository.save(user);
        });
    }
}
