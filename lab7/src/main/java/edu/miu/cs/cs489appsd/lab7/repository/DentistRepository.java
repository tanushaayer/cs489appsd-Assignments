package edu.miu.cs.cs489appsd.lab7.repository;

import edu.miu.cs.cs489appsd.lab7.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
