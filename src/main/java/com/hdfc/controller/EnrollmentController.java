package com.hdfc.controller;

import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;
import com.hdfc.service.EnrollmentService;
import com.hdfc.service.EnrollmentServiceImpl;
import lombok.RequiredArgsConstructor;
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
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/enrollments")
    public void createEnrollment(@RequestBody EnrollmentRequestDto enrollment){
        enrollmentService.addEnrollment(enrollment);
    }

    @GetMapping("/enrollments")
    public List<EnrollmentResponseDto> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/enrollments/{id}")
    public EnrollmentResponseDto getEnrollmentById(@PathVariable int id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @GetMapping("/enrollments/status/{status}")
    public List<EnrollmentResponseDto> getEnrollmentByStatus(@PathVariable String status) {
        return enrollmentService.getEnrollmentByStatus(status);
    }

    @GetMapping("/enrollments/employee/{employeeId}")
    public List<EnrollmentResponseDto> getEnrollmentByEmployeeId(@PathVariable int employeeId) {
        return enrollmentService.getEnrollmentByEmployeeId(employeeId);
    }

    @PutMapping("/enrollments/{id}/complete")
    public String updateEnrollment(@PathVariable int id) {
        enrollmentService.completeEnrollment(id);
        return "Enrollment updated successfully";
    }

    @PutMapping("/enrollments/{id}/cancel")
    public String cancelEnrollment(@PathVariable int id) {
        enrollmentService.cancelEnrollment(id);
        return "Enrollment updated successfully";
    }


}
