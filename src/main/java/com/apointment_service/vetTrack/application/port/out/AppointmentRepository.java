package com.apointment_service.vetTrack.application.port.out;

import com.apointment_service.vetTrack.domain.model.Appointment;

import java.util.Optional;

public interface AppointmentRepository {
    Appointment save(Appointment appointment);
    Optional<Appointment> findById(Long id);


}
