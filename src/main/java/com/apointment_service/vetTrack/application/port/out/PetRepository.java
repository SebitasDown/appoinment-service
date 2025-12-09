package com.apointment_service.vetTrack.application.port.out;

import com.apointment_service.vetTrack.domain.model.Pet;

import java.util.Optional;

public interface PetRepository {
    Pet save(Pet pet);
    Optional<Pet> findById(Long id);
}
