package com.example.student_management_system.dto;

import com.example.student_management_system.entity.Classes;
import com.example.student_management_system.entity.Major;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long classId;
    private Long majorId;
}
