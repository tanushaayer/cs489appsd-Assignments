package edu.miu.cs.cs489appsd.lab7.repository;

import edu.miu.cs.cs489appsd.lab7.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
