package com.ivanminyaev.coachhub.repository;

import com.ivanminyaev.coachhub.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Page<StudentEntity> findAddByUserId(long userId, Pageable pageable);
}
