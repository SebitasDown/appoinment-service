package com.apointment_service.vetTrack.infraestructure.in.web.dto.response;

import com.apointment_service.vetTrack.domain.model.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

    private Long id;
    private Long petId;
    private Long veterinarianId;
    private AppointmentStatus status;
    private LocalDate date;
    private LocalTime time;
}