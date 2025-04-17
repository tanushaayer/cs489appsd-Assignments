package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.DentistRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.DentistResponseDto;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    Optional<DentistResponseDto> createDentist(DentistRequestDto dto);
    List<DentistResponseDto> getAllDentists();
    Optional<DentistResponseDto> getDentistByEmail(String email);
    Optional<DentistResponseDto> updateDentist(String email, DentistRequestDto dto);
    void deleteDentist(String email);
}
