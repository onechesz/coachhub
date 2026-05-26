package com.ivanminyaev.coachhub.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentForListResponseDto {
    Long id;
    String firstName;
    String lastName;
}
