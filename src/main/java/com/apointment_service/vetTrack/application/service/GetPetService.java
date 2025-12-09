package com.apointment_service.vetTrack.application.service;

import com.apointment_service.vetTrack.application.port.in.GetPetByUseCase;
import com.apointment_service.vetTrack.application.port.out.PetRepository;
import com.apointment_service.vetTrack.domain.model.Pet;
import com.apointment_service.vetTrack.infraestructure.config.TransactionalUseCaseExecutor;

import java.util.Optional;

public class GetPetService implements GetPetByUseCase {

    private final PetRepository petRepository;
    private final TransactionalUseCaseExecutor transactionalUseCaseExecutor;

    public GetPetService(PetRepository petRepository, TransactionalUseCaseExecutor transactionalUseCaseExecutor) {
        this.petRepository = petRepository;
        this.transactionalUseCaseExecutor = transactionalUseCaseExecutor;
    }

    @Override
    public Optional<Pet> getPetById(Long id) {
        return transactionalUseCaseExecutor.executeReadOnly(() ->
                petRepository.findById(id)
        );
    }
}
