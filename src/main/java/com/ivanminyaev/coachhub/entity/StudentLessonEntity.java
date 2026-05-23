package com.ivanminyaev.coachhub.entity;

import com.ivanminyaev.coachhub.entity.enumeration.StudentLessonStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_lesson")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentLessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    LessonEntity lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    StudentEntity student;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    StudentLessonStatus status;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
}
