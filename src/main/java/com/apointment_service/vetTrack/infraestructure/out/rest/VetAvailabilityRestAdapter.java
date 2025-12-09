package com.apointment_service.vetTrack.infraestructure.out.rest;

import com.apointment_service.vetTrack.application.port.out.VetAvailabilityService;
import com.apointment_service.vetTrack.infraestructure.config.WebClientConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class VetAvailabilityRestAdapter implements VetAvailabilityService {

    private final WebClient vetAvailabilityWebClient;

    @Override
    public boolean isAvailable(Long veterinarianId, LocalDate date, LocalTime time) {
        Map response = vetAvailabilityWebClient.post()
                .uri("/availability")
                .bodyValue(Map.of(
                        "veterinarioId", veterinarianId,
                        "fecha", date.toString(),
                        "hora", time.toString()
                ))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return Boolean.TRUE.equals(response.get("disponible"));
    }
}