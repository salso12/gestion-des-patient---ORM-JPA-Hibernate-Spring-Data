package com.example.tpspring.service;

import com.example.tpspring.entities.Consultation;
import com.example.tpspring.entities.Medecin;
import com.example.tpspring.entities.Patient;
import com.example.tpspring.entities.RendezVous;

public interface HospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
