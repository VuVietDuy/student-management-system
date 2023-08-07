package com.example.student_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MajorDto {
    private String majorName;
    private String description;
    private int establishmentYear;

}
