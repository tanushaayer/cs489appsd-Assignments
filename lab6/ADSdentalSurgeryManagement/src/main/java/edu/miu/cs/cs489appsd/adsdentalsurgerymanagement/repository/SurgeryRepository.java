package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Surgery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
    @Transactional
    Optional<Surgery> findBySurgeryNumber(String surgeryNumber);
}
