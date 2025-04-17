package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.DentistRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.DentistResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Dentist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AppointmentMapper.class})
public interface DentistMapper {

    //dto to dentist
    @Mappings({@Mapping(source = "appointmentRequestDtos", target = "appointments")})
    Dentist dentistRequestDtoToDentist(DentistRequestDto dentistRequestDto);

    //dentist to dto
    @Mapping(source = "appointments", target = "appointmentResponseDtos")
    DentistResponseDto dentistToDentistResponseDto(Dentist dentist);

    @Mapping(source = "appointments", target = "appointmentResponseDtos")
    List<DentistResponseDto> dentistsToDentistResponseDtos(List<Dentist> dentists);
}
