package com.apointment_service.vetTrack.infraestructure.in.web.controller;


import com.apointment_service.vetTrack.application.port.in.CreateAppointmentUseCase;
import com.apointment_service.vetTrack.domain.model.Appointment;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.request.CreateAppointmentRequest;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.AppointmentResponse;
import com.apointment_service.vetTrack.infraestructure.in.web.mapper.AppointmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;
    private final AppointmentMapper appointmentMapper;

    @PostMapping
    public AppointmentResponse createAppointment(
            @RequestBody CreateAppointmentRequest request
    ) {

        Appointment appointment = createAppointmentUseCase.createAppointment(
                request.getPetId(),
                request.getVeterinarianId(),
                request.getDate(),
                request.getTime(),
                request.getReason()
        );

        return appointmentMapper.toResponse(appointment);
    }
}
