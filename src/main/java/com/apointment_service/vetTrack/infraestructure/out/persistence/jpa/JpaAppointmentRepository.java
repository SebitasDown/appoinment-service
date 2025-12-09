package com.apointment_service.vetTrack.infraestructure.out.persistence.jpa;

import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
