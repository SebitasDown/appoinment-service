package com.apointment_service.vetTrack.infraestructure.out.persistence.adapter;

import com.apointment_service.vetTrack.application.port.out.PetRepository;
import com.apointment_service.vetTrack.domain.model.Pet;
import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.PetEntity;
import com.apointment_service.vetTrack.infraestructure.out.persistence.mapper.PetMapperPersistence;
import com.apointment_service.vetTrack.infraestructure.out.persistence.jpa.JpaPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PetRepositoryAdapter implements PetRepository {

    private final JpaPetRepository petRepository;
    private final PetMapperPersistence petMapper;

    @Override
    public Pet save(Pet pet) {
        PetEntity entity = petMapper.toEntity(pet);
        PetEntity saved = petRepository.save(entity);
        return petMapper.toDomain(saved);
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id)
                .map(petMapper::toDomain);
    }
}
