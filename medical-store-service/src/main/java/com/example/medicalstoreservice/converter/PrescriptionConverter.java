package com.example.medicalstoreservice.converter;

import com.example.medicalstoreservice.dto.PrescriptionDTO;
import com.example.medicalstoreservice.model.Prescription;

import java.util.List;
import java.util.stream.Collectors;

public class PrescriptionConverter {

    public static PrescriptionDTO toDto(Prescription prescription) {
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setPatientId(prescription.getPatientId());
        dto.setDoctorId(prescription.getDoctorId());
        dto.setMedicationDetails(prescription.getMedicationDetails());
        dto.setPrescriptionDate(prescription.getPrescriptionDate());

        return dto;
    }

    public static Prescription toEntity(PrescriptionDTO dto) {
        Prescription prescription = new Prescription();
        prescription.setPatientId(dto.getPatientId());
        prescription.setDoctorId(dto.getDoctorId());
        prescription.setMedicationDetails(dto.getMedicationDetails());
        prescription.setPrescriptionDate(dto.getPrescriptionDate());

        return prescription;
    }

    public static List<PrescriptionDTO> toDtoList(List<Prescription> prescriptions) {
        return prescriptions.stream().map(PrescriptionConverter::toDto).collect(Collectors.toList());
    }
}
