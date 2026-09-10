package com.hdfc.service;


import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;
import com.hdfc.entity.Enrollment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnrollmentService {

    void addEnrollment(EnrollmentRequestDto enrollment);
    List<EnrollmentResponseDto> getAllEnrollments();
    EnrollmentResponseDto getEnrollmentById(int enrollmentId);
    void cancelEnrollment(int enrollmentId);
    void completeEnrollment(int enrollmentId);
    List<EnrollmentResponseDto> getEnrollmentByStatus(String status);
    List<EnrollmentResponseDto> getEnrollmentByEmployeeId(int employeeId);

}
