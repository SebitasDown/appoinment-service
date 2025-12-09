package com.apointment_service.vetTrack.application.port.in;

import com.apointment_service.vetTrack.domain.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CreateAppointmentUseCase {
    Appointment createAppointment(Long petId, Long veterinarianId, LocalDate date, LocalTime time, String reason);
}
