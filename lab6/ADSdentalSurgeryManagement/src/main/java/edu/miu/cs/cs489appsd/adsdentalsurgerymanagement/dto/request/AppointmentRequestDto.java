package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request;

import java.time.LocalDate;

public record AppointmentRequestDto(
        String appointmentNumber,
        LocalDate date,
        String status,
        SurgeryRequestDto surgeryRequestDto
) {
}
