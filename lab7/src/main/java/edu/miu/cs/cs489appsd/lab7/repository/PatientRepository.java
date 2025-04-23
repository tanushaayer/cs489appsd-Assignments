package edu.miu.cs.cs489appsd.lab7.repository;

import edu.miu.cs.cs489appsd.lab7.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE " +
            "LOWER(p.firstName) LIKE LOWER(CONCAT('%', :searchString, '%')) OR " +
            "LOWER(p.lastName) LIKE LOWER(CONCAT('%', :searchString, '%')) OR " +
            "LOWER(p.email) LIKE LOWER(CONCAT('%', :searchString, '%')) OR " +
            "p.phoneNumber LIKE CONCAT('%', :searchString, '%')")
    List<Patient> searchPatients(@Param("searchString") String searchString);
}
