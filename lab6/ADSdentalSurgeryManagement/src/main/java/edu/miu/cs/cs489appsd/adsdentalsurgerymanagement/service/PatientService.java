package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.PatientRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.PatientResponseDto;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Optional<PatientResponseDto> createPatient(PatientRequestDto dto);
    List<PatientResponseDto> getAllPatients();
    Optional<PatientResponseDto> getPatientByEmail(String email);
    Optional<PatientResponseDto> updatePatient(Long id, PatientRequestDto dto);
    void deletePatient(Long id);
}
