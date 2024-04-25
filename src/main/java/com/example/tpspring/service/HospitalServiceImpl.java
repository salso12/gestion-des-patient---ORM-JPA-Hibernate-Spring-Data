package com.example.tpspring.service;

import com.example.tpspring.entities.Consultation;
import com.example.tpspring.entities.Medecin;
import com.example.tpspring.entities.Patient;
import com.example.tpspring.entities.RendezVous;
import com.example.tpspring.repository.ConsultationRepository;
import com.example.tpspring.repository.MedecinReposetory;
import com.example.tpspring.repository.PatientRepository;
import com.example.tpspring.repository.RondezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    private PatientRepository patientRepository;
    private MedecinReposetory medecinReposetory;
    private RondezVousRepository rondezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinReposetory medecinReposetory, RondezVousRepository rondezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinReposetory = medecinReposetory;
        this.rondezVousRepository = rondezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinReposetory.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rondezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
