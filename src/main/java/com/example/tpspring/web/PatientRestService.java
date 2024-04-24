package com.example.tpspring.web;

import com.example.tpspring.entities.Patient;
import com.example.tpspring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientRestService {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null); // Return null if patient not found
    }
}
