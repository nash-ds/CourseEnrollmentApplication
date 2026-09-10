package com.hdfc.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enrollment {

    @NotBlank
    @S
    private int enrollmentId;

    @NotNull
    private int employeeId;

    @NotNull
    private String employeeName;

    @NotNull
    private int courseId;

    @NotNull
    private LocalDate enrollmentDate;

    // ENROLLED , COMPLETED , CANCELLED
    @NotNull
    private String status;
}
