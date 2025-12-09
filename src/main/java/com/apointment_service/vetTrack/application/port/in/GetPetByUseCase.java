package com.apointment_service.vetTrack.application.port.in;

import com.apointment_service.vetTrack.domain.model.Pet;

import java.util.Optional;

public interface GetPetByUseCase {
    Optional<Pet> getPetById(Long id);
}
