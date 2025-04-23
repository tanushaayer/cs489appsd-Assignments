package edu.miu.cs.cs489appsd.lab7.dto.request;

import java.time.LocalDate;
import java.util.List;

public record PatientRequestDto(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        LocalDate dob,
        AddressRequestDto addressRequestDto
) {
}
