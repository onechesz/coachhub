package com.ivanminyaev.coachhub.controller;

import com.ivanminyaev.coachhub.dto.request.StudentCreateRequest;
import com.ivanminyaev.coachhub.dto.response.StudentForListResponseDto;
import com.ivanminyaev.coachhub.dto.response.StudentResponseDto;
import com.ivanminyaev.coachhub.entity.UserEntity;
import com.ivanminyaev.coachhub.security.AuthFacade;
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
    AuthFacade authFacade;
    StudentService studentService;

    @GetMapping
    public Page<StudentForListResponseDto> getAll() {
        final UserEntity user = authFacade.getCurrentUser();
        final Page<StudentForListResponseDto> response = studentService.getAll(user.getId());

        return response;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentForListResponseDto create(@Valid @RequestBody StudentCreateRequest request) {
        final UserEntity user = authFacade.getCurrentUser();
        final StudentForListResponseDto response = studentService.create(request, user.getId());

        return response;
    }

    @GetMapping(path = "/{id}")
    public StudentResponseDto get(@PathVariable Long id) {
        final UserEntity user = authFacade.getCurrentUser();
        final StudentResponseDto response = studentService.get(id, user.getId());

        return response;
    }
}
