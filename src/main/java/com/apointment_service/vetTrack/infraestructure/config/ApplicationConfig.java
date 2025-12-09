package com.apointment_service.vetTrack.infraestructure.config;

import com.apointment_service.vetTrack.application.port.in.CreateAppointmentUseCase;
import com.apointment_service.vetTrack.application.port.out.AppointmentRepository;
import com.apointment_service.vetTrack.application.port.out.PetRepository;
import com.apointment_service.vetTrack.application.service.CreateAppointmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    CreateAppointmentUseCase createAppointmentUseCase(
            PetRepository petRepository,
            AppointmentRepository appointmentRepository,
            TransactionalUseCaseExecutor executor
    ) {
        return new CreateAppointmentService(
                petRepository,
                appointmentRepository,
                executor
        );
    }
}
