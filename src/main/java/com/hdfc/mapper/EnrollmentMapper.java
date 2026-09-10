package com.hdfc.mapper;

import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;
import com.hdfc.entity.Enrollment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    public EnrollmentResponseDto toResponse(Enrollment enrollment);
    public Enrollment toEntity(EnrollmentRequestDto enrollmentRequestDto);
    public List<EnrollmentResponseDto> toResponseList(List<Enrollment> enrollments);
}
