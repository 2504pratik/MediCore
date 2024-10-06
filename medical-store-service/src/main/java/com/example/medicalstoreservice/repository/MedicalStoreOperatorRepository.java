package com.example.medicalstoreservice.repository;

import com.example.medicalstoreservice.model.MedicalStoreOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalStoreOperatorRepository extends JpaRepository<MedicalStoreOperator,Long> {
    MedicalStoreOperator findByOperatorId(String operatorId);
}
