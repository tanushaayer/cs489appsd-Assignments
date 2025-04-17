package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AddressRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.AddressResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    // mapper method to map from addressRequestDto to address
    Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto);

    //mapper method to map from address to addressResponseDto
    AddressResponseDto addressToAddressResponseDto(Address address);
}
