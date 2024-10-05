package com.example.patientservice.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
}
