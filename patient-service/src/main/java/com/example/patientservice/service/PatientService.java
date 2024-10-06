package com.example.patientservice.service;

import com.example.patientservice.converter.AddressConverter;
import com.example.patientservice.converter.MedicalHistoryConverter;
import com.example.patientservice.converter.PatientConverter;
import com.example.patientservice.dto.PatientDTO;
import com.example.patientservice.models.MedicalHistory;
import com.example.patientservice.models.Patient;
import com.example.patientservice.repository.MedicalHistoryRepository;
import com.example.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Transactional
    public void createPatient(PatientDTO patientDTO){
        Patient patient = patientRepository.save(PatientConverter.toEntity(patientDTO));

        // Iterate over the list of medical histories and save each one
        if (patientDTO.getMedicalHistory() != null) {
            patientDTO.getMedicalHistory().forEach(medicalHistoryDTO -> {
                MedicalHistory medicalHistory = MedicalHistoryConverter.toEntity(medicalHistoryDTO);
                medicalHistory.setPatient(patient); // Set the patient reference in each medical history
                medicalHistoryRepository.save(medicalHistory);  // Save the medical history
            });
        }
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
