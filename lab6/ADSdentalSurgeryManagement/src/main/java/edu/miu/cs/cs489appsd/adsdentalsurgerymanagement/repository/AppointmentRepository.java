package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Appointment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Transactional
    Optional<Appointment> findByAppointmentNumber(String appointmentNumber);
}
