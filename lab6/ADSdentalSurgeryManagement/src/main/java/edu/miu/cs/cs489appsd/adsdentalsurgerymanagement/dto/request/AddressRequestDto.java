package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request;

public record AddressRequestDto(
        String unitNo,
        String street,
        String city,
        String state,
        Integer zip
) {
}
