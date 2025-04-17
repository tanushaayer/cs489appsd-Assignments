package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AppointmentRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.AppointmentResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Dentist;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Patient;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Optional<AppointmentResponseDto> createAppointment(AppointmentRequestDto dto);
    Optional<AppointmentResponseDto> createAppointment(AppointmentRequestDto dto, Dentist dentist, Patient patient);
    List<AppointmentResponseDto> getAllAppointments();
    Optional<AppointmentResponseDto> getAppointmentByAppointmentNumber(String appointmentNumber);
    Optional<AppointmentResponseDto> updateAppointment(String appointmentNumber, AppointmentRequestDto dto);
    void deleteAppointment(Long id);
}
