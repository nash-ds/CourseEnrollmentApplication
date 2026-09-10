package com.hdfc.service;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;
import com.hdfc.entity.Course;
import com.hdfc.mapper.CourseMapper;
import com.hdfc.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository repository ;
    private final CourseMapper mapper;

    @Override
    public void addCourse(CourseRequestDto course) {
        //course fee must be always positive
        if(course.getFees() < 0){
            throw new RuntimeException("Course fee must be positive");
        }
        //
        repository.save(mapper.toEntity(course));
    }

    @Override
    public CourseResponseDto getCourseById(int courseId) {
        Course course = repository.getById(courseId);
        return mapper.toResponse(course);
    }

    @Override
    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses = repository.getAll();
        return mapper.toResponseList(courses);
    }

    @Override
    public void updateCourse(CourseRequestDto course) {
        Course c = mapper.toEntity(course);
        repository.update(c.getCourseId(),c);
    }

    @Override
    public void deleteCourse(int courseId) {
        repository.remove(courseId);
    }

    @Override
    public List<CourseResponseDto> getCourseByTrainer(String trainerName) {
        List<CourseResponseDto> filteredCourses = new ArrayList<>();
        for(CourseResponseDto c : getAllCourses()){
            if(c.getTrainerName().equals(trainerName)){
                filteredCourses.add(c);
            }
        }
        return filteredCourses;
    }

    @Override
    public List<CourseResponseDto> getCourseLessThan(double fees) {
        List<CourseResponseDto> filteredCourses = new ArrayList<>();
        for(CourseResponseDto c : getAllCourses()){
            if(c.getFees() < fees){
                filteredCourses.add(c);
            }
        }
        return filteredCourses;
    }
}
