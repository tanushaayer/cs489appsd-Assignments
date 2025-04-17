package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.PatientRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.PatientResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AppointmentMapper.class, AddressMapper.class})
public interface PatientMapper {

    @Mappings({@Mapping(source = "appointmentRequestDtos", target="appointments"), @Mapping(source = "addressRequestDto", target="address")})
    Patient patientRequestDtoToPatient(PatientRequestDto patientRequestDto);

    @Mappings({@Mapping(source = "appointments", target = "appointmentResponseDtos"), @Mapping(source = "address", target = "addressResponseDto")})
    PatientResponseDto patientToPatientResponseDto(Patient patient);

    @Mappings({@Mapping(source = "appointments", target = "appointmentResponseDtos"), @Mapping(source = "address", target = "addressResponseDto")})
    List<PatientResponseDto> patientsToPatientResponseDtos(List<Patient> patients);

}
