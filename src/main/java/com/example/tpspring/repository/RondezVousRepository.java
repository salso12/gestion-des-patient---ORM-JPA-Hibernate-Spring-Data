package com.example.tpspring.repository;

import com.example.tpspring.entities.Patient;
import com.example.tpspring.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RondezVousRepository extends JpaRepository<RendezVous, Long> {
}
