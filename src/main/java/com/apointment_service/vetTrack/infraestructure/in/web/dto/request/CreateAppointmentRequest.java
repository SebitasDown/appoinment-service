package com.apointment_service.vetTrack.infraestructure.in.web.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentRequest {

    private Long petId;
    private Long veterinarianId;
    private LocalDate date;
    private LocalTime time;
    private String reason;
}
