package com.apointment_service.vetTrack.infraestructure.out.persistence.adapter;

import com.apointment_service.vetTrack.application.port.out.UserRepository;
import com.apointment_service.vetTrack.domain.model.User;
import com.apointment_service.vetTrack.infraestructure.out.persistence.entity.UserEntity;
import com.apointment_service.vetTrack.infraestructure.out.persistence.jpa.JpaUserRepository;
import com.apointment_service.vetTrack.infraestructure.out.persistence.mapper.UserPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository userRepository;
    private final UserPersistenceMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity entity = userMapper.toEntity(user);
        UserEntity saved = userRepository.save(entity);
        return userMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::toDomain);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
