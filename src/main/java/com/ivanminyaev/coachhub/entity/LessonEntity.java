package com.ivanminyaev.coachhub.entity;

import com.ivanminyaev.coachhub.entity.enumeration.LessonType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "lesson")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String description;

    @Column(name = "date_start")
    LocalDateTime dateStart;

    @Column(name = "date_end")
    LocalDateTime dateEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type", nullable = false)
    LessonType lessonType;

    @Column(nullable = false)
    boolean regular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_id")
    LessonEntity next;

    @Column(nullable = false)
    LocalDateTime createdAt;
}
