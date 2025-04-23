package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequestDto(
        String appointmentNumber,
        LocalDate date,
        LocalTime appointmentTime,
        String status,
        SurgeryRequestDto surgeryRequestDto
) {
}
