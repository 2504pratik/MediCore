package com.example.medicalstoreservice.converter;

import com.example.medicalstoreservice.dto.MedicalStoreOperatorDTO;
import com.example.medicalstoreservice.model.MedicalStoreOperator;

public class MedicalStoreOperatorConverter {

    public static MedicalStoreOperatorDTO toDto(MedicalStoreOperator operator) {
        MedicalStoreOperatorDTO dto = new MedicalStoreOperatorDTO();
        dto.setOperatorId(operator.getOperatorId());
        dto.setStoreName(operator.getStoreName());
        dto.setOwnerName(operator.getOwnerName());
        dto.setEmail(operator.getEmail());
        dto.setPhoneNumber(operator.getPhoneNumber());
        dto.setAddress(AddressConverter.toDto(operator.getAddress()));

        return dto;
    }

    public static MedicalStoreOperator toEntity(MedicalStoreOperatorDTO dto) {
        MedicalStoreOperator operator = new MedicalStoreOperator();
        operator.setOperatorId(dto.getOperatorId());
        operator.setStoreName(dto.getStoreName());
        operator.setOwnerName(dto.getOwnerName());
        operator.setEmail(dto.getEmail());
        operator.setPhoneNumber(dto.getPhoneNumber());
        operator.setAddress(AddressConverter.toEntity(dto.getAddress()));

        return operator;
    }
}
