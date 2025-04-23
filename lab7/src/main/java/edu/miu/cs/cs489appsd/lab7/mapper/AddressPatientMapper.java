package edu.miu.cs.cs489appsd.lab7.mapper;

import edu.miu.cs.cs489appsd.lab7.dto.response.AddressWithPatientResponseDto;
import edu.miu.cs.cs489appsd.lab7.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressPatientMapper {

    @Mapping(source = "patient", target = "patientResponseDto")
    AddressWithPatientResponseDto addressToAddressWithPatientDto(Address address);

    @Mapping(source = "patient", target = "patientResponseDto")
    List<AddressWithPatientResponseDto> addressListToAddressWithPatientDtoList(List<Address> addresses);
}
