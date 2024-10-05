package com.example.patientservice.repository;

import com.example.patientservice.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByPatientId(String patientId);
}
