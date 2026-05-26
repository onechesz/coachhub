package com.ivanminyaev.coachhub.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class StudentCreateRequest {
    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    String description;

    @Size(max = 32)
    String telegram;

    @Size(max = 32)
    String whatsapp;

    @Size(max = 32)
    String phone;
}
