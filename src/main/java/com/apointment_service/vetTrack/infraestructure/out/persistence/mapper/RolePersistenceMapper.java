package com.apointment_service.vetTrack.infraestructure.out.persistence.mapper;

import com.apointment_service.vetTrack.domain.model.Role;
import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolePersistenceMapper {
    RoleEntity toEntity(Role role);

    Role toDomain(RoleEntity entity);
}
