package com.hdfc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDto {

    @Schema(example = "1")
    private Integer courseId;

    @Schema(example = "JDBC course")
    private String courseName;

    @Schema(example = "Ratan")
    private String trainerName;

    @Schema(example = "4")
    private Integer durationInDays;

    @Schema(example = "2")
    private Integer maxCapacity;

    @Schema(example = "10000")
    private Double fees;
}
