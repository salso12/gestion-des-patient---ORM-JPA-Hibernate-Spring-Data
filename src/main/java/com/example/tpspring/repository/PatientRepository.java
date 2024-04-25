package com.example.tpspring.repository;

import com.example.tpspring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMalade(boolean malade);
    Patient findByNom(String name);
}
