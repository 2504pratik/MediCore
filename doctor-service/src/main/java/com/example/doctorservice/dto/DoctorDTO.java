package com.example.doctorservice.dto;

import com.example.doctorservice.model.Address;
import lombok.Data;

@Data
public class DoctorDTO {
    private String doctorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String specialization;
    private Address address;
}
