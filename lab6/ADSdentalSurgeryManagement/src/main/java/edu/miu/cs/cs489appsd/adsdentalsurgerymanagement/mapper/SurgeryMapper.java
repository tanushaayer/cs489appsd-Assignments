package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.SurgeryRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.SurgeryResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Surgery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AddressMapper.class})
public interface SurgeryMapper {

    @Mapping(source = "addressRequestDto", target = "location")
    Surgery surgeryRequestDtoToSurgery(SurgeryRequestDto surgeryRequestDto);

    @Mapping(source = "location", target = "addressResponseDto")
    SurgeryResponseDto surgeryResponseDtoToSurgery(Surgery surgery);
}
