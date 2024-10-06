package com.example.doctorservice.service;

import com.example.doctorservice.converter.DoctorConverter;
import com.example.doctorservice.dto.DoctorDTO;
import com.example.doctorservice.model.Doctor;
import com.example.doctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorDTO getDoctorById(String doctorId) {
        Doctor doctor = doctorRepository.findByDoctorId(doctorId);
        return doctor != null ? DoctorConverter.toDto(doctor) : null;
    }

    @Transactional
    public void createDoctor(DoctorDTO doctorDTO) {
        doctorRepository.save(DoctorConverter.toEntity(doctorDTO));
    }

    @Transactional
    public void updateDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findByDoctorId(doctorDTO.getDoctorId());
        if (doctor != null) {
            doctor.setFirstName(doctorDTO.getFirstName());
            doctor.setLastName(doctorDTO.getLastName());
            doctor.setEmail(doctorDTO.getEmail());
            doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
            doctor.setSpecialization(doctorDTO.getSpecialization());
            doctor.setAddress(doctorDTO.getAddress());
            doctorRepository.save(doctor);
        }
    }
}
