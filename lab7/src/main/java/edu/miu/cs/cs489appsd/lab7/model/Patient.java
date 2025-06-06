package edu.miu.cs.cs489appsd.lab7.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 32)
    private String firstName;
    @Column(nullable = false, length = 32)
    private String lastName;
    @Column(nullable = false, length = 12, unique = true)
    private String phoneNumber;
    @Column(nullable = false, length = 32, unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "patient")
    List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
}
