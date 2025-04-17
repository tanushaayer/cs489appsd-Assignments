package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AppointmentRequestDto;

import java.util.List;

public record DentistResponseDto(
        String firstName,
        String lastName,
        String specialization,
        List<AppointmentResponseDto> appointmentResponseDtos
) {
}
