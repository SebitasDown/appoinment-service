package com.apointment_service.vetTrack.application.service;

import com.apointment_service.vetTrack.application.port.in.CreatePetUseCase;
import com.apointment_service.vetTrack.application.port.out.PetRepository;
import com.apointment_service.vetTrack.domain.model.Pet;
import com.apointment_service.vetTrack.domain.model.Species;
import com.apointment_service.vetTrack.infraestructure.config.TransactionalUseCaseExecutor;

public class CreatePetService implements CreatePetUseCase {

    private final PetRepository petRepository;
    private final TransactionalUseCaseExecutor transactionalUseCaseExecutor;

    public CreatePetService(PetRepository petRepository, TransactionalUseCaseExecutor transactionalUseCaseExecutor) {
        this.petRepository = petRepository;
        this.transactionalUseCaseExecutor = transactionalUseCaseExecutor;
    }

    @Override
    public Pet createPet(String name, String ownerName, String ownerDocument, int age, Species species) {
        return transactionalUseCaseExecutor.executeInTransaction(() -> {
            Pet pet = new Pet(name, species, age, ownerDocument, ownerName);
            return petRepository.save(pet);
        });
    }
}
