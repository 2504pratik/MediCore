package com.example.medicalstoreservice.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PrescriptionDTO {
    private String patientId;
    private String doctorId;
    private String medicationDetails;
    private LocalDateTime prescriptionDate;
}
