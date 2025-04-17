package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request;

import java.util.List;

public record DentistRequestDto(
        String firstName,
        String lastName,
        String email,
        String phone,
        String specialization,
        List<AppointmentRequestDto> appointmentRequestDtos
) {
}
