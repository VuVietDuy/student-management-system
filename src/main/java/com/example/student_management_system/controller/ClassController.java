package com.example.student_management_system.controller;

import com.example.student_management_system.dto.ClassDto;
import com.example.student_management_system.service.ClassService;
import com.example.student_management_system.utils.AppConstants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        super();
        this.classService = classService;
    }

    @GetMapping("/{id}")
    public ClassDto getClassById(@PathVariable("id") Long classId) {
        return classService.getClassById(classId);
    }

    @GetMapping()
    public List<ClassDto> getAllClasses(
            @RequestParam(value = "majorId" , defaultValue = AppConstants.DEFAULT_MAJOR, required = false) Long majorId,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_DIRECTION, required = false) String sortDir
    ) {
        return classService.getAllClasses(majorId, sortBy, sortDir);
    }
}
