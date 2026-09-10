package com.hdfc.service;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;
import com.hdfc.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    void addCourse(CourseRequestDto course);
    CourseResponseDto getCourseById(int courseId);
    List<CourseResponseDto> getAllCourses();
    void updateCourse(CourseRequestDto course);
    void deleteCourse(int courseId);
    List<CourseResponseDto> getCourseByTrainer(String trainerName);
    List<CourseResponseDto> getCourseLessThan(double fees);
}
