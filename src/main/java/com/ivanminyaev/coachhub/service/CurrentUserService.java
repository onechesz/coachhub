package com.ivanminyaev.coachhub.service;

import com.ivanminyaev.coachhub.entity.UserEntity;

import java.util.Optional;

public interface CurrentUserService {
    Optional<UserEntity> getCurrentUser();
}
