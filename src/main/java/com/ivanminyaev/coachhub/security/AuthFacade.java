package com.ivanminyaev.coachhub.security;

import com.ivanminyaev.coachhub.entity.UserEntity;
import com.ivanminyaev.coachhub.exception.UserNotFoundException;
import com.ivanminyaev.coachhub.service.CurrentUserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AuthFacade {
    CurrentUserService currentUserService;

    public UserEntity getCurrentUser() {
        return currentUserService.getCurrentUser().orElseThrow(UserNotFoundException::new);
    }
}
