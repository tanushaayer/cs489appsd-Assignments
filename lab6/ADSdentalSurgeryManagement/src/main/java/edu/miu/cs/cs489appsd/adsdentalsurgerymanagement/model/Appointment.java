package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String appointmentNumber;

    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime appointmentTime;
    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentitst_id")
    private Dentist dentist;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;
}
