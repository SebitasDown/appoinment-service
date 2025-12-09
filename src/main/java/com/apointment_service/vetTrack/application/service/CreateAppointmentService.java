package com.apointment_service.vetTrack.application.service;

import com.apointment_service.vetTrack.application.port.in.CreateAppointmentUseCase;
import com.apointment_service.vetTrack.application.port.out.AppointmentRepository;
import com.apointment_service.vetTrack.application.port.out.PetRepository;
import com.apointment_service.vetTrack.domain.model.Appointment;
import com.apointment_service.vetTrack.domain.model.Pet;
import com.apointment_service.vetTrack.infraestructure.config.TransactionalUseCaseExecutor;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateAppointmentService implements CreateAppointmentUseCase {

    private final PetRepository petRepository;
    private final AppointmentRepository appointmentRepository;
    private final TransactionalUseCaseExecutor transactionalUseCaseExecutor;

    public CreateAppointmentService(PetRepository petRepository, AppointmentRepository appointmentRepository, TransactionalUseCaseExecutor transactionalUseCaseExecutor) {
        this.petRepository = petRepository;
        this.appointmentRepository = appointmentRepository;
        this.transactionalUseCaseExecutor = transactionalUseCaseExecutor;
    }

    @Override
    public Appointment createAppointment(Long petId, Long veterinarianId, LocalDate date, LocalTime time, String reason) {
        return transactionalUseCaseExecutor.executeInTransaction(() -> {

            Pet pet = petRepository.findById(petId)
                    .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

            pet.validateCanRequestAppointment();

            Appointment appointment = new Appointment(
                    pet,
                    veterinarianId,
                    date,
                    time,
                    reason
            );

            return appointmentRepository.save(appointment);
        });
    }
}