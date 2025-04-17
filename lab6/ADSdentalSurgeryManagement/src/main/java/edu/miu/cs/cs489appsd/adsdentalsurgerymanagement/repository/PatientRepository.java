package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
}
