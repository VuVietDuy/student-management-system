package com.example.student_management_system.dto;

import lombok.Data;

@Data
public class JWTAuthResponse {
    private String accessToken;
    private String tokenType = "Beare";
}
