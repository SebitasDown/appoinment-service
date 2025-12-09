package com.apointment_service.vetTrack.application.port.in;

import com.apointment_service.vetTrack.domain.model.Pet;
import com.apointment_service.vetTrack.domain.model.Species;

public interface CreatePetUseCase {
    Pet createPet(String name, String ownerName, String ownerDocument, int age, Species species);
}
