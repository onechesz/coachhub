package com.ivanminyaev.coachhub.service;

import com.ivanminyaev.coachhub.dto.request.StudentCreateRequest;
import com.ivanminyaev.coachhub.dto.response.StudentForListResponseDto;
import com.ivanminyaev.coachhub.dto.response.StudentResponseDto;
import org.springframework.data.domain.Page;

public interface StudentService {
    Page<StudentForListResponseDto> getAll(long userId);

    StudentForListResponseDto create(StudentCreateRequest request, long userId);

    StudentResponseDto get(long id, long userId);
}
