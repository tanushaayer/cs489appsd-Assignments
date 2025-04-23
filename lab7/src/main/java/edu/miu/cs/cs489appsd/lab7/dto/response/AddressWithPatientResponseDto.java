package edu.miu.cs.cs489appsd.lab7.dto.response;

public record AddressWithPatientResponseDto(
        String unitNo,
        String street,
        String city,
        String state,
        Integer zip,
        PatientResponseDto patientResponseDto
) {
}
