package com.ivanminyaev.coachhub.repository;

import com.ivanminyaev.coachhub.dto.response.StudentLessonForListDto;
import com.ivanminyaev.coachhub.entity.StudentLessonEntity;
import com.ivanminyaev.coachhub.entity.enumeration.StudentLessonStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentLessonRepository extends JpaRepository<StudentLessonEntity, Long> {
    @Query(value = """
            select new com.ivanminyaev.coachhub.dto.response.StudentLessonForListDto(
                l.description,
                l.dateStart,
                l.dateEnd
            )
            from StudentLessonEntity sl
                     join sl.lesson l
            where sl.student.id = :studentId
              and sl.status = 'PLANNED'
              and l.dateEnd > current_timestamp
              and l.user.id = :userId
            order by l.dateEnd""")
    List<StudentLessonForListDto> findUpcomingLessons(long studentId, long userId, StudentLessonStatus status, Pageable pageable);
}
