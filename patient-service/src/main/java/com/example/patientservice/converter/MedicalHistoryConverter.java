package com.example.patientservice.converter;

import com.example.patientservice.dto.MedicalHistoryDTO;
import com.example.patientservice.models.MedicalHistory;

import java.util.List;
import java.util.stream.Collectors;

public class MedicalHistoryConverter {

    public static MedicalHistoryDTO toDto(MedicalHistory medicalHistory) {
        MedicalHistoryDTO dto = new MedicalHistoryDTO();

        dto.setDiagnosis(medicalHistory.getDiagnosis());
        dto.setTreatment(medicalHistory.getTreatment());
        dto.setDoctorName(medicalHistory.getDoctorName());
        dto.setDateOfVisit(medicalHistory.getDateOfVisit());

        return dto;
    }

    public static MedicalHistory toEntity(MedicalHistoryDTO dto) {
        MedicalHistory medicalHistory = new MedicalHistory();

        medicalHistory.setDiagnosis(dto.getDiagnosis());
        medicalHistory.setTreatment(dto.getTreatment());
        medicalHistory.setDoctorName(dto.getDoctorName());
        medicalHistory.setDateOfVisit(dto.getDateOfVisit());

        return medicalHistory;
    }

    // Converts a list of MedicalHistory entities to a list of MedicalHistoryDTOs
    public static List<MedicalHistoryDTO> toDtoList(List<MedicalHistory> medicalHistoryList) {
        return medicalHistoryList.stream()
                .map(MedicalHistoryConverter::toDto)
                .collect(Collectors.toList());
    }

    // Converts a list of MedicalHistoryDTOs to a list of MedicalHistory entities
    public static List<MedicalHistory> toEntityList(List<MedicalHistoryDTO> medicalHistoryDTOList) {
        return medicalHistoryDTOList.stream()
                .map(MedicalHistoryConverter::toEntity)
                .collect(Collectors.toList());
    }
}
