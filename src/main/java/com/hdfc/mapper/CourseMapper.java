package com.hdfc.mapper;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;
import com.hdfc.entity.Course;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseResponseDto toResponse(Course course);
    Course toEntity(CourseRequestDto courseRequestDto);
    List<CourseResponseDto> toResponseList(List<Course> course);

}
