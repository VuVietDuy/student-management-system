package com.example.student_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

//    @Column(name = "date_of_birth")
//    private Date dateOfBirth;
//
//    @Column(name = "gender")
//    private int gender;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "instructor_course",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    @CreationTimestamp
    private Date create_at;

}
