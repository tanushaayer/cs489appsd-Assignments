package edu.miu.cs.cs489appsd.lab7.dto.request;

import java.time.LocalDate;

public record AppointmentRequestDto(
        String appointmentNumber,
        LocalDate date,
        String status,
        Long doctorId,
        Long patientId
) {
}
