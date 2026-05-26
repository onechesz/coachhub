package com.ivanminyaev.coachhub.service;

import com.ivanminyaev.coachhub.dto.request.StudentCreateRequest;
import com.ivanminyaev.coachhub.dto.response.StudentForListResponseDto;
import org.springframework.data.domain.Page;

public interface StudentService {
    Page<StudentForListResponseDto> getAll();

    StudentForListResponseDto create(StudentCreateRequest request);
}
