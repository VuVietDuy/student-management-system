package com.example.student_management_system.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException extends Throwable {
    private HttpStatus httpStatus;
    private String message;

    public ApiException(String message ,HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
