package com.apointment_service.vetTrack.infraestructure.out.persistence.jpa;

import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPetRepository extends JpaRepository<PetEntity, Long> {
}
