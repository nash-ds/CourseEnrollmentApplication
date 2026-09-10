package com.hdfc.service;

import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;
import com.hdfc.entity.Course;
import com.hdfc.entity.Enrollment;
import com.hdfc.mapper.EnrollmentMapper;
import com.hdfc.repository.CourseRepository;
import com.hdfc.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService{

    private final EnrollmentRepository repository;
    private final CourseRepository courseRepository;
    private final EnrollmentMapper mapper;

    @Override
    public void addEnrollment(EnrollmentRequestDto enrollment) {
        int courseId = enrollment.getCourseId();
        Course c = courseRepository.getById(courseId);
        if(c == null){
            throw new RuntimeException("Course not found");
        }
        //check if the course max capacity is filles or not before adding enrollment
        List<EnrollmentResponseDto> enrollments = getAllEnrollments();
        long count = enrollments.stream()
                                .filter(e -> e.getCourseId() == courseId)
                                .count();
        if(count >= c.getMaxCapacity()){
            throw new RuntimeException("Course is full");
        }

        //same employee cannot enroll in smae course
        long e_count = enrollments.stream()
                                .filter(e -> e.getEmployeeId() == enrollment.getEmployeeId() && e.getCourseId() == courseId)
                                .count();
        if(e_count > 0){
            throw new RuntimeException("Employee already enrolled in this course");
        }
        
        Enrollment e =mapper.toEntity(enrollment);
        e.setStatus("ENROLLED");
        e.setEnrollmentDate(LocalDate.now());
        repository.save(e);

    }

    @Override
    public List<EnrollmentResponseDto> getAllEnrollments() {
        List<Enrollment> enrollments = repository.getAll();
        return mapper.toResponseList(enrollments);
    }

    @Override
    public EnrollmentResponseDto getEnrollmentById(int enrollmentId) {
        return mapper.toResponse(repository.getById(enrollmentId));
    }

    @Override
    public void cancelEnrollment(int enrollmentId) {
        Enrollment e = repository.getById(enrollmentId);
        e.setStatus("CANCELLED");
    }

    @Override
    public void completeEnrollment(int enrollmentId) {
        Enrollment e = repository.getById(enrollmentId);
        e.setStatus("COMPLETED");
    }

    @Override
    public List<EnrollmentResponseDto> getEnrollmentByStatus(String status) {
        List<EnrollmentResponseDto> enrollmentByStatus = new ArrayList<>();
        for(EnrollmentResponseDto e : getAllEnrollments()){
            if(e.getStatus().equals(status)){
                enrollmentByStatus.add(e);
            }
        }
        return enrollmentByStatus;
    }

    @Override
    public List<EnrollmentResponseDto> getEnrollmentByEmployeeId(int employeeId) {
        List<EnrollmentResponseDto> enrollmentByEmployeeId = new ArrayList<>();
        for(EnrollmentResponseDto e : getAllEnrollments()){
            if(e.getEmployeeId() == employeeId){
                enrollmentByEmployeeId.add(e);
            }
        }
        return enrollmentByEmployeeId;
    }
}
