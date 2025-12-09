package com.apointment_service.vetTrack.infraestructure.out.persistence.mapper;

import com.apointment_service.vetTrack.domain.model.User;
import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RolePersistenceMapper.class})
public interface UserPersistenceMapper {
    @Mapping(source = "roles", target = "roles")
    UserEntity toEntity(User user);

    @Mapping(source = "roles", target = "roles")
    User toDomain(UserEntity entity);
}
