package com.example.medicalstoreservice.dto;

import lombok.Data;

@Data
public class MedicalStoreOperatorDTO {
    private String operatorId;
    private String storeName;
    private String ownerName;
    private String email;
    private String phoneNumber;
    private AddressDTO address;
}
