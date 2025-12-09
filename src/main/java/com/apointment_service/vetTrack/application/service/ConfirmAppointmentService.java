package com.apointment_service.vetTrack.application.service;

import com.apointment_service.vetTrack.application.port.in.ConfirmAppointmentUseCase;
import com.apointment_service.vetTrack.application.port.out.AppointmentRepository;
import com.apointment_service.vetTrack.application.port.out.VetAvailabilityService;
import com.apointment_service.vetTrack.domain.model.Appointment;
import com.apointment_service.vetTrack.infraestructure.config.TransactionalUseCaseExecutor;

public class ConfirmAppointmentService implements ConfirmAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;
    private final VetAvailabilityService availabilityService;
    private final TransactionalUseCaseExecutor transactionalUseCaseExecutor;

    public ConfirmAppointmentService(AppointmentRepository appointmentRepository,
                                     VetAvailabilityService availabilityService,
                                     TransactionalUseCaseExecutor transactionalUseCaseExecutor) {
        this.appointmentRepository = appointmentRepository;
        this.availabilityService = availabilityService;
        this.transactionalUseCaseExecutor = transactionalUseCaseExecutor;
    }

    @Override
    public void confirmAppointment(Long appointmentId) {
        transactionalUseCaseExecutor.executeInTransaction(() -> {

            Appointment appointment = appointmentRepository.findById(appointmentId)
                    .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

            boolean available = availabilityService.isAvailable(
                    appointment.getVeterinarianId(),
                    appointment.getDate(),
                    appointment.getTime()
            );

            if (!available) {
                appointment.cancel();
                appointmentRepository.save(appointment);
                return null;
            }

            appointment.confirm();
            appointmentRepository.save(appointment);

            return null;
        });
    }
}
