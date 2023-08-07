package com.example.student_management_system.controller;

import com.example.student_management_system.dto.InstructorDto;
import com.example.student_management_system.entity.Instructor;
import com.example.student_management_system.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> getInstrutorById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @PostMapping()
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto instructorDto) {
        return ResponseEntity.ok(instructorService.createInstructor(instructorDto));
    }
}
