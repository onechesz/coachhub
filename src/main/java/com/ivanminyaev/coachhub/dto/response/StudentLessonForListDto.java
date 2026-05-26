package com.ivanminyaev.coachhub.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentLessonForListDto {
    String description;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime dateStart;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime dateEnd;
}
