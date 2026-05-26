package com.ivanminyaev.coachhub.service.impl;

import com.ivanminyaev.coachhub.dto.request.StudentCreateRequest;
import com.ivanminyaev.coachhub.dto.response.StudentForListResponseDto;
import com.ivanminyaev.coachhub.entity.StudentEntity;
import com.ivanminyaev.coachhub.entity.UserEntity;
import com.ivanminyaev.coachhub.exception.UserNotFoundException;
import com.ivanminyaev.coachhub.repository.StudentRepository;
import com.ivanminyaev.coachhub.service.CurrentUserService;
import com.ivanminyaev.coachhub.service.StudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    CurrentUserService currentUserService;
    StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<StudentForListResponseDto> getAll() {
        final UserEntity user = currentUserService.getCurrentUser().orElseThrow(UserNotFoundException::new);
        final Pageable pageable = PageRequest.of(0, 20, Sort.by("createdAt"));

        final Page<StudentEntity> students = studentRepository.findAddByUserId(user.getId(), pageable);
        final Page<StudentForListResponseDto> response = students.map(student -> StudentForListResponseDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName()).build());

        return response;
    }

    @Override
    public StudentForListResponseDto create(StudentCreateRequest request) {
        final UserEntity user = currentUserService.getCurrentUser().orElseThrow(UserNotFoundException::new);

        final StudentEntity student = saveStudent(
                request.getFirstName(),
                request.getLastName(),
                request.getDescription(),
                request.getTelegram(),
                request.getWhatsapp(),
                request.getPhone(),
                user
        );
        final StudentForListResponseDto response = StudentForListResponseDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName()).build();

        return response;
    }

    private StudentEntity saveStudent(String firstName, String lastName, String description, String telegram, String whatsapp, String phone, UserEntity user) {
        StudentEntity student = new StudentEntity();

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDescription(description);
        student.setTelegram(telegram);
        student.setWhatsapp(whatsapp);
        student.setPhone(phone);
        student.setUser(user);
        student.setCreatedAt(LocalDateTime.now());

        student = studentRepository.save(student);

        return student;
    }
}
