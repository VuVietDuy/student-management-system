package com.example.student_management_system.entity;

import jakarta.persistence.*;



public enum Role {
    ADMIN, INSTRUCTOR, STUDENT;
    public static Role getRole(String role) {
        for (Role r : Role.values()) {
            if (r.name().equals(role)) {
                return r;
            }
        }
        return null;
    }
}
