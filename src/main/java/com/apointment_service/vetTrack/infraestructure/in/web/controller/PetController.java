package com.apointment_service.vetTrack.infraestructure.in.web.controller;

import com.apointment_service.vetTrack.application.port.in.CreatePetUseCase;
import com.apointment_service.vetTrack.application.port.in.GetPetByUseCase;
import com.apointment_service.vetTrack.domain.model.Pet;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.request.CreatePetRequest;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.PetResponse;
import com.apointment_service.vetTrack.infraestructure.in.web.mapper.PetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final CreatePetUseCase createPetUseCase;
    private final GetPetByUseCase getPetByUseCase;
    private final PetMapper petMapper;

    @PostMapping
    public PetResponse createPet(@RequestBody CreatePetRequest request) {
        Pet pet = createPetUseCase.createPet(
                request.getName(),
                request.getOwnerName(),
                request.getOwnerDocument(),
                request.getAge(),
                request.getSpecies()
        );
        return petMapper.toResponse(pet);
    }

    @GetMapping("/{id}")
    public PetResponse getPet(@PathVariable Long id) {
        Pet pet = getPetByUseCase.getPetById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        return petMapper.toResponse(pet);
    }
}
