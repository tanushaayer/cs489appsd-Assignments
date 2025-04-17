package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AddressRequestDto;

public record SurgeryResponseDto(
        String surgeryNumber,
        String surgeryName,
        AddressResponseDto addressResponseDto
) {
}
