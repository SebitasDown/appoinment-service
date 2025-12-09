package com.apointment_service.vetTrack.infraestructure.out.persistence.mapper;

import com.apointment_service.vetTrack.domain.model.Appointment;
import com.apointment_service.vetTrack.infraestructure.in.web.dto.response.AppointmentResponse;
import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.AppointmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapperPersistence {

    AppointmentMapperPersistence INSTANCE = Mappers.getMapper(AppointmentMapperPersistence.class);

    @Mapping(source = "pet", target = "pet")
    @Mapping(source = "status", target = "status")
    AppointmentEntity toEntity(Appointment appointment);

    @Mapping(source = "pet", target = "pet")
    @Mapping(source = "status", target = "status")
    Appointment toDomain(AppointmentEntity entity);
}
