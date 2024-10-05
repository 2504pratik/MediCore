package com.example.patientservice.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "medical_history")
@Data
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private String diagnosis;
    private String treatment;
    private String doctorName;

    @Temporal(TemporalType.DATE)
    private Date dateOfVisit;
}
