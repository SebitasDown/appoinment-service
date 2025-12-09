package com.apointment_service.vetTrack.infraestructure.out.persistence.mapper;

import com.apointment_service.vetTrack.domain.model.Pet;
import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.PetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapperPersistence {

    PetEntity toEntity(Pet pet);

    Pet toDomain(PetEntity entity);
}