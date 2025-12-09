package com.apointment_service.vetTrack.application.port.out;

import java.time.LocalDate;
import java.time.LocalTime;

// Esto es del microservicio
public interface VetAvailabilityService {
    boolean isAvailable(
            Long veterinarianId,
            LocalDate date,
            LocalTime time
    );
}
