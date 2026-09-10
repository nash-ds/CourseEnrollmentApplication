package com.hdfc.controller;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;
import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.service.CourseService;
import com.hdfc.service.CourseServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/courses")
    public void createCourse(@RequestBody CourseRequestDto course){
        courseService.addCourse(course);
    }

    @GetMapping("/courses")
    public List<CourseResponseDto> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public CourseResponseDto getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/courses/trainer/{trainerName}")
    public List<CourseResponseDto> getCourseByTrainer(@PathVariable String trainerName) {
        return courseService.getCourseByTrainer(trainerName);
    }   

    @GetMapping("/courses/fees/{amount}")
    public List<CourseResponseDto> getCourseLessThan(@PathVariable double amount) {
        return courseService.getCourseLessThan(amount);
    }

    @PutMapping("/courses/{id}")
    public String updateCourse(@PathVariable int id, @RequestBody CourseRequestDto course) {
        courseService.updateCourse(course);
        return "Course updated successfully";
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return "Course deleted successfully";
    }

}
