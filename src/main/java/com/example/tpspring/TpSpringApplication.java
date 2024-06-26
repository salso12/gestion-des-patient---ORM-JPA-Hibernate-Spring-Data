package com.example.tpspring;

import com.example.tpspring.entities.*;
import com.example.tpspring.repository.*;
import com.example.tpspring.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class TpSpringApplication {
    // @Autowired
//    private ProductRepo productRepo;
//    @Autowired
//    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(TpSpringApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        productRepo.save(new product(null,"computer",263.8,4));
//        productRepo.save(new product(null,"phone",63.8,5));
//        productRepo.save(new product(null,"tablet",93.8,3));
//        List<product>products= productRepo.findAll();
//        products.forEach(p -> {
//            System.out.println(p.toString());
//        });
//        product product=productRepo.findById(Long.valueOf(1)).get();
//        System.out.println("****************");
//        System.out.println(product.getId());
//        System.out.println(product.getName());
//        System.out.println(product.getPrice());
//        System.out.println("*****************");
//        System.out.println("-------------product list ----------");
//        List<product> productList=productRepo.findByNameContains("C");
//        productList.forEach(p->{
//            System.out.println(p);
//        });


        // Adding patients
//        patientRepository.save(new Patient(null, "Alice", new Date(), false, 90));
//        patientRepository.save(new Patient(null, "Bob", new Date(), true, 70));
//        patientRepository.save(new Patient(null, "Charlie", new Date(), true, 60));
//
//        // Fetching all patients
//        List<Patient> patients = patientRepository.findAll();
//        System.out.println("------------- All Patients ------------");
//        patients.forEach(patient -> System.out.println(patient.toString()));
//
//        // Fetching a single patient by ID
//        Patient patient = patientRepository.findById(1L).orElse(null);
//        if (patient != null) {
//            System.out.println("------------- Patient Details ------------");
//            System.out.println("ID: " + patient.getId());
//            System.out.println("Name: " + patient.getNom());
//            System.out.println("Date of Birth: " + patient.getDateNaissance());
//            System.out.println("Is Sick: " + patient.isMalade());
//            System.out.println("Score: " + patient.getScore());
//            System.out.println("-----------------------------------------");
//        }
//
//        // Finding patients by sickness status
//        System.out.println("------------- Sick Patients ------------");
//        List<Patient> sickPatients = patientRepository.findByMalade(true);
//        sickPatients.forEach(p -> System.out.println(p.toString()));
//
//        // Updating a patient
//        patientRepository.findById(2L).ifPresent(p -> {
//            p.setNom("Updated Bob");
//            patientRepository.save(p);
//            System.out.println("Updated patient: " + p.toString());
//        });
//
//        // Deleting a patient
//        patientRepository.findById(3L).ifPresent(p -> {
//            patientRepository.delete(p);
//            System.out.println("Deleted patient with ID: " + p.getId());
//        });
//
//    }
//
    @Bean
    CommandLineRunner start(HospitalService hospitalService,MedecinReposetory medecinReposetory,PatientRepository patientRepository,RondezVousRepository rondezVousRepository){
        return args -> {
            Stream.of("Mohamed","Hassan","Najat").forEach(name->{
                Patient pation=new Patient();
                pation.setNom(name);
                pation.setDateNaissance(new Date());
                pation.setMalade(false);
                hospitalService.savePatient(pation);
            });
            Stream.of("malak","aziz","karim").forEach(name->{
                Medecin medecin=new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentist");
                hospitalService.saveMedecin(medecin);
            });
            Patient patient= patientRepository.findById(46L).orElse(null);
            Patient patient1= patientRepository.findByNom("hassan");
            Medecin medecin= medecinReposetory.findByNom("malak");

            RendezVous rendezVous= new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1=rondezVousRepository.findById(7L).orElse(null);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation .......");
            hospitalService.saveConsultation(consultation);
        };
    }
}