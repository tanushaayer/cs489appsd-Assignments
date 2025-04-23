package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.DentistRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.PatientRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.SurgeryRequestDto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentResponseDto(
        String appointmentNumber,
        LocalDate date,
        LocalTime appointmentTime,
        String status,
        SurgeryResponseDto surgeryResponseDto
) {
}
