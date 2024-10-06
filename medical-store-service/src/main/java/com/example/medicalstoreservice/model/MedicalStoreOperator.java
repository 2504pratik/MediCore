package com.example.medicalstoreservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medical_store_operators")
@Data
public class MedicalStoreOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String operatorId;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Embedded
    private Address address;
}
