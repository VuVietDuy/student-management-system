package com.example.student_management_system.dto;

import com.example.student_management_system.entity.Major;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassDto {
    private String className;
    private String description;
    private Long majorId;
}
