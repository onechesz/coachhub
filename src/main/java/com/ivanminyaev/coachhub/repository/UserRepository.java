package com.ivanminyaev.coachhub.repository;

import com.ivanminyaev.coachhub.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
