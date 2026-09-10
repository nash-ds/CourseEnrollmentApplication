package com.hdfc.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    @NotBlank
    private int courseId;

    @NotBlank
    private String courseName;

    @NotBlank
    private String trainerName;

    @NotBlank
    @Positive 
    private int durationInDays;

    @NotBlank
    @Positive 
    private int maxCapacity;

    @NonNull 
    @Positive
    private double fees;
}
