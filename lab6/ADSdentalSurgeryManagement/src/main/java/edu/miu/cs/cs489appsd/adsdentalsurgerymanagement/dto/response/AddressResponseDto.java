package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response;

public record AddressResponseDto(
        String unitNo,
        String street,
        String city,
        String state,
        Integer zip
) {
}
