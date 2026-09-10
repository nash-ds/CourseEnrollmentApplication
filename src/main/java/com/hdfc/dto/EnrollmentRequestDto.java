package com.hdfc.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class EnrollmentRequestDto {

    @NotNull
    private int enrollmentId;

    @NotNull
    private int employeeId;

    @NotNull
    private String employeeName;

    @NotNull
    private int courseId;

}
