package edu.miu.cs.cs489appsd.lab7.service;

import edu.miu.cs.cs489appsd.lab7.dto.request.AppointmentRequestDto;
import edu.miu.cs.cs489appsd.lab7.dto.request.PatientRequestDto;
import edu.miu.cs.cs489appsd.lab7.dto.response.PatientResponseDto;
import edu.miu.cs.cs489appsd.lab7.model.Patient;

import java.util.List;

public interface PatientService {
    PatientResponseDto createPatient(PatientRequestDto patientRequestDto);
    List<PatientResponseDto> getAllPatients();
    PatientResponseDto getPatientById(Long id);
    PatientResponseDto updatePatient( Long id, PatientRequestDto patientRequestDto);
    void deletePatient(Long id);
    List<PatientResponseDto> searchPatients(String searchString);

}
