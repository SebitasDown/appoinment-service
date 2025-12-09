package com.apointment_service.vetTrack.infraestructure.out.persistence.adapter;

import com.apointment_service.vetTrack.application.port.out.RoleRepository;
import com.apointment_service.vetTrack.domain.model.Role;
import com.apointment_service.vetTrack.infraestructure.out.persistence.jpa.JpaRoleRepository;
import com.apointment_service.vetTrack.infraestructure.out.persistence.mapper.RolePersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepository {

    private final JpaRoleRepository roleRepository;
    private final RolePersistenceMapper roleMapper;


    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name)
                .map(roleMapper::toDomain);
    }
}
