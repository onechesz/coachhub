package com.ivanminyaev.coachhub.service.impl;

import com.ivanminyaev.coachhub.dto.request.StudentCreateRequest;
import com.ivanminyaev.coachhub.dto.response.StudentForListResponseDto;
import com.ivanminyaev.coachhub.dto.response.StudentLessonForListDto;
import com.ivanminyaev.coachhub.dto.response.StudentResponseDto;
import com.ivanminyaev.coachhub.entity.StudentEntity;
import com.ivanminyaev.coachhub.entity.UserEntity;
import com.ivanminyaev.coachhub.entity.enumeration.StudentLessonStatus;
import com.ivanminyaev.coachhub.exception.StudentNotFoundException;
import com.ivanminyaev.coachhub.repository.StudentLessonRepository;
import com.ivanminyaev.coachhub.repository.StudentRepository;
import com.ivanminyaev.coachhub.repository.UserRepository;
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
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    UserRepository userRepository;
    StudentLessonRepository studentLessonRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<StudentForListResponseDto> getAll(long userId) {
        final Pageable pageable = PageRequest.of(0, 20, Sort.by("createdAt"));

        final Page<StudentEntity> students = studentRepository.findAddByUserId(userId, pageable);
        final Page<StudentForListResponseDto> response = students.map(student -> StudentForListResponseDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName()).build());

        return response;
    }

    @Override
    public StudentForListResponseDto create(StudentCreateRequest request, long userId) {
        final UserEntity user = userRepository.findById(userId).orElse(null);

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

    @Override
    @Transactional(readOnly = true)
    public StudentResponseDto get(long id, long userId) {
        final StudentEntity student = studentRepository.findByIdAndUserId(id, userId)
                .orElseThrow(StudentNotFoundException::new);
        final List<StudentLessonForListDto> lessons = studentLessonRepository
                .findUpcomingLessons(student.getId(), userId, StudentLessonStatus.PLANNED, Pageable.ofSize(5));
        final StudentResponseDto response = StudentResponseDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .description(student.getDescription())
                .telegram(student.getTelegram())
                .whatsapp(student.getWhatsapp())
                .phone(student.getPhone())
                .createdAt(student.getCreatedAt().toLocalDate())
                .lessons(lessons).build();

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
