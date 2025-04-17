package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AppointmentRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.AppointmentResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SurgeryMapper.class})
public interface AppointmentMapper {

    @Mapping(source = "surgeryRequestDto", target = "surgery")
    Appointment appointmentRequestDtoToAppointment(AppointmentRequestDto appointmentRequestDto);

    @Mapping(source = "surgery", target = "surgeryRequestDto")
    AppointmentRequestDto appointmentToAppointmentRequestDto(Appointment appointment);

    @Mapping(source = "surgery", target = "surgeryResponseDto")
    AppointmentResponseDto appointmentToAppointmentResponseto(Appointment appointment);

    @Mapping(source = "surgery", target = "surgeryResponseDto")
    List<AppointmentResponseDto> appointmentsToAppointmentResponsetos(List<Appointment> appointments);
}
