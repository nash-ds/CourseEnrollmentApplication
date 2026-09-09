package com.hdfc.entity;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    private int courseId;
    private String courseName;
    private String trainerName;
    private int durationInDays;
    private int maxCapacity;
    private double fees;
}
