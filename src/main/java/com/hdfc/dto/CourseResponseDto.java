package com.hdfc.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class CourseResponseDto {
    private String courseName;
    private String trainerName;
    private Integer maxCapacity;
    private Double fees;

}
