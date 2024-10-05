package com.example.patientservice.dto;

import com.example.patientservice.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {
    private String patientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private Gender gender;
    private AddressDTO address;
    private List<MedicalHistoryDTO> medicalHistory;
}
