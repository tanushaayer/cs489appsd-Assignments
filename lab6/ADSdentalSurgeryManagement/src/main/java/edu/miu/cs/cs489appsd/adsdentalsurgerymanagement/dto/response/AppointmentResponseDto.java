package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.DentistRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.PatientRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.SurgeryRequestDto;

import java.time.LocalDate;

public record AppointmentResponseDto(
        String appointmentNumber,
        LocalDate date,
        String status,
        SurgeryResponseDto surgeryResponseDto
) {
}
