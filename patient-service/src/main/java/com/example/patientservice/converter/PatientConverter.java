package com.example.patientservice.converter;

import com.example.patientservice.dto.PatientDTO;
import com.example.patientservice.models.Patient;

import java.util.stream.Collectors;

public class PatientConverter {

    public static PatientDTO toDto(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setPatientId(patient.getPatientId());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setEmail(patient.getEmail());
        dto.setPhoneNumber(patient.getPhoneNumber());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setGender(patient.getGender());
        dto.setAddress(AddressConverter.toDto(patient.getAddress()));
        dto.setMedicalHistory(patient.getMedicalHistory()
                .stream()
                .map(MedicalHistoryConverter::toDto)
                .collect(Collectors.toList()));

        return dto;
    }

    public static Patient toEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setPatientId(dto.getPatientId());
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setEmail(dto.getEmail());
        patient.setPhoneNumber(dto.getPhoneNumber());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setGender(dto.getGender());
        patient.setAddress(AddressConverter.toEntity(dto.getAddress()));

        return patient;
    }
}
