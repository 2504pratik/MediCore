package com.example.medicalstoreservice.controller;

import com.example.medicalstoreservice.dto.MedicalStoreOperatorDTO;
import com.example.medicalstoreservice.dto.PrescriptionDTO;
import com.example.medicalstoreservice.service.MedicalStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-stores")
public class MedicalStoreController {

    @Autowired
    private MedicalStoreService medicalStoreService;

    @GetMapping("/{operatorId}")
    public ResponseEntity<MedicalStoreOperatorDTO> getOperatorById(@PathVariable String operatorId) {
        MedicalStoreOperatorDTO operatorDTO = medicalStoreService.getOperatorById(operatorId);
        return operatorDTO != null ? new ResponseEntity<>(operatorDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MedicalStoreOperatorDTO> createOperator(@RequestBody MedicalStoreOperatorDTO operatorDTO) {
        medicalStoreService.createOperator(operatorDTO);
        return new ResponseEntity<>(operatorDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{operatorId}")
    public ResponseEntity<MedicalStoreOperatorDTO> updateOperator(@PathVariable String operatorId, @RequestBody MedicalStoreOperatorDTO operatorDTO) {
        operatorDTO.setOperatorId(operatorId);
        medicalStoreService.updateOperator(operatorDTO);
        return new ResponseEntity<>(operatorDTO, HttpStatus.OK);
    }

    @GetMapping("/prescriptions/{patientId}")
    public ResponseEntity<List<PrescriptionDTO>> getPrescriptionsByPatientId(@PathVariable String patientId) {
        List<PrescriptionDTO> prescriptions = medicalStoreService.getPrescriptionsByPatientId(patientId);
        return !prescriptions.isEmpty() ? new ResponseEntity<>(prescriptions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/prescriptions")
    public ResponseEntity<PrescriptionDTO> createPrescription(@RequestBody PrescriptionDTO prescriptionDTO) {
        medicalStoreService.createPrescription(prescriptionDTO);
        return new ResponseEntity<>(prescriptionDTO, HttpStatus.CREATED);
    }
}
