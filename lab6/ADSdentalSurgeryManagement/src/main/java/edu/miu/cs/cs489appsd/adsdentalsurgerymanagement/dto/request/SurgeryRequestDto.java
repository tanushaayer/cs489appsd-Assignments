package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request;

public record SurgeryRequestDto(
        String surgeryName,
        String surgeryNumber,
        String phone,
        AddressRequestDto addressRequestDto
) {
}
