package com.apointment_service.vetTrack.infraestructure.out.persistence.adapter;

import com.apointment_service.vetTrack.application.port.out.AppointmentRepository;
import com.apointment_service.vetTrack.domain.model.Appointment;
import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.AppointmentEntity;
import com.apointment_service.vetTrack.infraestructure.out.persistence.jpa.JpaAppointmentRepository;
import com.apointment_service.vetTrack.infraestructure.out.persistence.mapper.AppointmentMapperPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

// Recordar Problems details
@Component
@RequiredArgsConstructor
public class AppointmentRepositoryAdapter implements AppointmentRepository {

    private final JpaAppointmentRepository appointmentRepository;
    private final AppointmentMapperPersistence appointmentMapper;

    @Override
    public Appointment save(Appointment appointment) {
        AppointmentEntity entity = appointmentMapper.toEntity(appointment);
        AppointmentEntity saved = appointmentRepository.save(entity);
        return appointmentMapper.toDomain(saved);
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id)
                .map(appointmentMapper::toDomain);
    }
}
