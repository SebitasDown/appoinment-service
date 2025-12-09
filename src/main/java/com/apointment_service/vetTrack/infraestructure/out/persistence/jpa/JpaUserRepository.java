package com.apointment_service.vetTrack.infraestructure.out.persistence.jpa;

import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}
