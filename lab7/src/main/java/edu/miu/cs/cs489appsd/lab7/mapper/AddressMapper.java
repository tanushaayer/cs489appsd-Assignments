package edu.miu.cs.cs489appsd.lab7.mapper;

import edu.miu.cs.cs489appsd.lab7.dto.request.AddressRequestDto;
import edu.miu.cs.cs489appsd.lab7.dto.response.AddressResponseDto;
import edu.miu.cs.cs489appsd.lab7.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    //dto to address
    Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto);

    //address to response
    AddressResponseDto addressToAddressResponseDto(Address address);

    //List of address to List of response
    List<AddressResponseDto> addressListToAddressResponseDtoList(List<Address> addresses);
}
