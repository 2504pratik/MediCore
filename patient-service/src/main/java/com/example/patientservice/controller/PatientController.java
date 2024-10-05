package com.example.patientservice.controller;

import com.example.patientservice.dto.PatientDTO;
import com.example.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Get patient details by patient ID
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable String patientId) {
        PatientDTO patientDTO = patientService.getPatientById(patientId);
        if (patientDTO != null) {
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new patient
    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO) {
        patientService.createPatient(patientDTO);
        return new ResponseEntity<>(patientDTO, HttpStatus.CREATED);
    }

    // Update an existing patient
    @PutMapping("/{patientId}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable String patientId, @RequestBody PatientDTO patientDTO) {
        patientDTO.setPatientId(patientId);  // Ensure the patientId is set
        patientService.updatePatient(patientDTO);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }
}
