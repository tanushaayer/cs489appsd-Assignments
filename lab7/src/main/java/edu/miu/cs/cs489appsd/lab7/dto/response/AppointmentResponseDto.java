package edu.miu.cs.cs489appsd.lab7.dto.response;

import java.time.LocalDate;

public record AppointmentResponseDto(
        String appointmentNumber,
        LocalDate date,
        String status
) {
}
