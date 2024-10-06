package com.example.doctorservice.controller;

import com.example.doctorservice.dto.DoctorDTO;
import com.example.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable String doctorId) {
        DoctorDTO doctorDTO = doctorService.getDoctorById(doctorId);
        if (doctorDTO != null) {
            return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.createDoctor(doctorDTO);
        return new ResponseEntity<>(doctorDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable String doctorId, @RequestBody DoctorDTO doctorDTO) {
        doctorDTO.setDoctorId(doctorId);  // Ensure the doctorId is set
        doctorService.updateDoctor(doctorDTO);
        return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
    }
}
