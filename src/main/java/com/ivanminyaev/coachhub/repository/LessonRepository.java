package com.ivanminyaev.coachhub.repository;

import com.ivanminyaev.coachhub.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {

}
