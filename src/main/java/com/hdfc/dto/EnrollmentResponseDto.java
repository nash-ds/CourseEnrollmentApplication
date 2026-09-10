package com.hdfc.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
public class EnrollmentResponseDto {

    private Integer employeeId;

    private String employeeName;

    private Integer courseId;

    private LocalDate enrollmentDate;

    private String status;
}
