package edu.miu.cs.cs489appsd.lab7.dto.request;

public record AddressRequestDto(
        String unitNo,
        String street,
        String city,
        String state,
        Integer zip
) {
}
