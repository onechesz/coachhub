package com.ivanminyaev.coachhub.repository;

import com.ivanminyaev.coachhub.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
