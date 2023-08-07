package com.example.student_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToMany(mappedBy = "courses",  cascade = CascadeType.ALL)
    private List<Instructor> instructors;

}
