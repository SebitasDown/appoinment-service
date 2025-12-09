package com.apointment_service.vetTrack.infraestructure.in.web.mapper;

import com.apointment_service.vetTrack.domain.model.Appointment;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.AppointmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "pet.id", target = "petId")
    AppointmentResponse toResponse(Appointment appointment);
}
