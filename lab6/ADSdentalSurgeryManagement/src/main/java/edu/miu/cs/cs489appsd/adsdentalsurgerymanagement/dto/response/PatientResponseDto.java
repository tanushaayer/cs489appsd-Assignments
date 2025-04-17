package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AddressRequestDto;

import java.time.LocalDate;
import java.util.List;

public record PatientResponseDto(
        String firstName,
        String lastName,
        String phoneNumber,
        AddressResponseDto addressResponseDto,
        List<AppointmentResponseDto> appointmentResponseDtos
) {
}
