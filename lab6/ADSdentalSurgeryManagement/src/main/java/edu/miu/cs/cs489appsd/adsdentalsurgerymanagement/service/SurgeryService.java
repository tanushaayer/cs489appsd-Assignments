package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.SurgeryRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.SurgeryResponseDto;

import java.util.List;

public interface SurgeryService {
    SurgeryResponseDto createSurgery(SurgeryRequestDto dto);
    List<SurgeryResponseDto> getAllSurgeries();
    SurgeryResponseDto getSurgeryById(Long id);
    SurgeryResponseDto updateSurgery(Long id, SurgeryRequestDto dto);
    void deleteSurgery(Long id);
}
