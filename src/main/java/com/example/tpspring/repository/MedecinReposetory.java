package com.example.tpspring.repository;

import com.example.tpspring.entities.Medecin;
import com.example.tpspring.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinReposetory extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
