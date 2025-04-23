package edu.miu.cs.cs489appsd.lab7.mapper;

import edu.miu.cs.cs489appsd.lab7.dto.request.PatientRequestDto;
import edu.miu.cs.cs489appsd.lab7.dto.response.PatientResponseDto;
import edu.miu.cs.cs489appsd.lab7.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper {

    //dto to patient
    @Mapping(source = "addressRequestDto", target = "address")
    Patient patientRequestToPatient(PatientRequestDto patientRequestDto);

    //patient to dto
    @Mappings({@Mapping(source = "address", target = "addressResponseDto"), @Mapping(source = "appointments", target = "appointmentResponseDtos")})
    PatientResponseDto patientToPatientResponseDto(Patient patient);

    //list of patientresponsedto
    @Mappings({@Mapping(source = "address", target = "addressResponseDto"), @Mapping(source = "appointments", target = "appointmentResponseDtos")})
    List<PatientResponseDto> patientListToPatientResponseDtoList(List<Patient> patients);
}
