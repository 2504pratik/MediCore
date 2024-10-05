package com.example.patientservice.dto;

import com.example.patientservice.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalHistoryDTO {
    private String diagnosis;
    private String treatment;
    private String doctorName;
    private Date dateOfVisit;
}
