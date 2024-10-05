package com.example.patientservice.converter;

import com.example.patientservice.dto.AddressDTO;
import com.example.patientservice.models.Address;

public class AddressConverter {

    public static AddressDTO toDto(Address address){
        AddressDTO dto = new AddressDTO();

        dto.setAddressLine1(address.getAddressLine1());
        dto.setAddressLine2(address.getAddressLine2());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setPostalCode(address.getPostalCode());

        return dto;
    }

    public static Address toEntity(AddressDTO dto){
        Address address = new Address();

        address.setAddressLine1(dto.getAddressLine1());
        address.setAddressLine2(dto.getAddressLine2());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPostalCode(dto.getPostalCode());

        return address;
    }
}
