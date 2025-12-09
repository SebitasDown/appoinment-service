package com.apointment_service.vetTrack.infraestructure.in.web.mapper;

import com.apointment_service.vetTrack.domain.model.Pet;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.PetResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetResponse toResponse(Pet pet);
}
