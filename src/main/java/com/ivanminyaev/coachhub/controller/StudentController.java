package com.ivanminyaev.coachhub.controller;

import com.ivanminyaev.coachhub.dto.request.StudentCreateRequest;
import com.ivanminyaev.coachhub.dto.response.StudentForListResponseDto;
import com.ivanminyaev.coachhub.service.StudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/students")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class StudentController {
    StudentService studentService;

    @GetMapping
    public Page<StudentForListResponseDto> getAll() {
        final Page<StudentForListResponseDto> response = studentService.getAll();

        return response;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentForListResponseDto create(@Valid @RequestBody StudentCreateRequest request) {
        final StudentForListResponseDto response = studentService.create(request);

        return response;
    }
}
