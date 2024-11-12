package com.example.authservice.dto;

import com.example.authservice.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;  // "PATIENT", "DOCTOR", or "OPERATOR"
}
