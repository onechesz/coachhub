package com.ivanminyaev.coachhub.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponseDto {
    String firstName;
    String lastName;
    String description;
    String telegram;
    String whatsapp;
    String phone;
    LocalDate createdAt;
    List<StudentLessonForListDto> lessons;
}
