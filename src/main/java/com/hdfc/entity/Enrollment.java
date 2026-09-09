package com.hdfc.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enrollment {

    private int enrollmentId;

    private int employeeId;

    private String employeeName;

    private int courseId;

    private LocalDate enrollmentDate;

    // ENROLLED , COMPLETED , CANCELLED
    private String status;
}
