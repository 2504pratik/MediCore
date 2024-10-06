package com.example.medicalstoreservice.service;

import com.example.medicalstoreservice.converter.AddressConverter;
import com.example.medicalstoreservice.dto.MedicalStoreOperatorDTO;
import com.example.medicalstoreservice.dto.PrescriptionDTO;
import com.example.medicalstoreservice.model.MedicalStoreOperator;
import com.example.medicalstoreservice.model.Prescription;
import com.example.medicalstoreservice.repository.MedicalStoreOperatorRepository;
import com.example.medicalstoreservice.repository.PrescriptionRepository;
import com.example.medicalstoreservice.converter.MedicalStoreOperatorConverter;
import com.example.medicalstoreservice.converter.PrescriptionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicalStoreService {

    @Autowired
    private MedicalStoreOperatorRepository operatorRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public MedicalStoreOperatorDTO getOperatorById(String operatorId) {
        MedicalStoreOperator operator = operatorRepository.findByOperatorId(operatorId);
        return operator != null ? MedicalStoreOperatorConverter.toDto(operator) : null;
    }

    @Transactional
    public void createOperator(MedicalStoreOperatorDTO operatorDTO) {
        operatorRepository.save(MedicalStoreOperatorConverter.toEntity(operatorDTO));
    }

    @Transactional
    public void updateOperator(MedicalStoreOperatorDTO operatorDTO) {
        MedicalStoreOperator operator = operatorRepository.findByOperatorId(operatorDTO.getOperatorId());
        if (operator != null) {
            operator.setStoreName(operatorDTO.getStoreName());
            operator.setOwnerName(operatorDTO.getOwnerName());
            operator.setEmail(operatorDTO.getEmail());
            operator.setPhoneNumber(operatorDTO.getPhoneNumber());
            operator.setAddress(AddressConverter.toEntity(operatorDTO.getAddress()));

            operatorRepository.save(operator);
        }
    }

    public List<PrescriptionDTO> getPrescriptionsByPatientId(String patientId) {
        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);
        return PrescriptionConverter.toDtoList(prescriptions);
    }

    @Transactional
    public void createPrescription(PrescriptionDTO prescriptionDTO) {
        prescriptionRepository.save(PrescriptionConverter.toEntity(prescriptionDTO));
    }
}
