package com.example.patientservice.service;

import com.example.patientservice.converter.AddressConverter;
import com.example.patientservice.converter.MedicalHistoryConverter;
import com.example.patientservice.converter.PatientConverter;
import com.example.patientservice.dto.PatientDTO;
import com.example.patientservice.models.Patient;
import com.example.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void createPatient(PatientDTO patientDTO){
        patientRepository.save(PatientConverter.toEntity(patientDTO));
    }

    public PatientDTO getPatientById(String patientId) {
        Patient patient = patientRepository.findByPatientId(patientId);
        return PatientConverter.toDto(patient);
    }

    @Transactional
    public void updatePatient(PatientDTO patientDTO){
        Patient patient = patientRepository.findByPatientId(patientDTO.getPatientId());
        if (patient != null) {
            patient.setFirstName(patientDTO.getFirstName());
            patient.setLastName(patientDTO.getLastName());
            patient.setEmail(patientDTO.getEmail());
            patient.setPhoneNumber(patientDTO.getPhoneNumber());
            patient.setDateOfBirth(patientDTO.getDateOfBirth());
            patient.setGender(patientDTO.getGender());
            patient.setAddress(AddressConverter.toEntity(patientDTO.getAddress()));
            patient.setMedicalHistory(MedicalHistoryConverter.toEntityList(patientDTO.getMedicalHistory()));

            patientRepository.save(patient);
        }
    }
}
