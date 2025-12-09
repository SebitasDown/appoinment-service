package com.apointment_service.vetTrack.infraestructure.out.persistence.jpa;

import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.RoleEntity;
import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaRoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String rolename);
}
