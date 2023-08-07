package com.example.student_management_system.controller;

import com.example.student_management_system.dto.MajorDto;
import com.example.student_management_system.entity.Major;
import com.example.student_management_system.service.MajorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/majors")
public class MajorController {

    private final MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MajorDto> getMajorById(@PathVariable("id") Long majorId) {
        return ResponseEntity.ok(majorService.getMajorById(majorId));
    }

    @PostMapping()
    public ResponseEntity<MajorDto> createMajor(@RequestBody MajorDto majorDto) {
        return ResponseEntity.ok(majorService.createMajor(majorDto));
    }
}
