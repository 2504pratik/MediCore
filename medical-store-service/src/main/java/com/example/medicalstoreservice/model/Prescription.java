package com.example.medicalstoreservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "prescriptions")
@Data
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientId;  // Reference to the patient

    @Column(nullable = false)
    private String doctorId;  // Reference to the doctor

    @Column(nullable = false)
    private String medicationDetails;

    @Column(nullable = false)
    private LocalDateTime prescriptionDate;
}
