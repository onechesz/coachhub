package com.ivanminyaev.coachhub.service.impl;

import com.ivanminyaev.coachhub.entity.UserEntity;
import com.ivanminyaev.coachhub.repository.UserRepository;
import com.ivanminyaev.coachhub.service.CurrentUserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MockCurrentUserService implements CurrentUserService {
    UserRepository userRepository;

    @Override
    public Optional<UserEntity> getCurrentUser() {
        Optional<UserEntity> userOptional = userRepository.findById(1L);

        return userOptional;
    }
}
