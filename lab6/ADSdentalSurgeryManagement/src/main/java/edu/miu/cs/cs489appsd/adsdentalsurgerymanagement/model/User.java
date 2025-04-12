package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.common.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 32)
    private String email;

    private String firstName;
    private String lastName;

    private UserRole userRole;

}
