package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AppointmentRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.DentistRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.AppointmentResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.DentistResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper.AppointmentMapper;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper.DentistMapper;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper.SurgeryMapper;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Appointment;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Dentist;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository.AppointmentRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository.DentistRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.AppointmentService;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.DentistService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DentistServiceImpl implements DentistService {
    private final DentistRepository dentistRepository;
    private final DentistMapper dentistMapper;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentService appointmentService;
    private final SurgeryMapper surgeryMapper;
    private final AppointmentMapper appointmentMapper;


    @Override
    @Transactional
    public Optional<DentistResponseDto> createDentist(DentistRequestDto dto) {
        Optional<Dentist> optionalDentist = dentistRepository.findByEmail(dto.email());
        if (optionalDentist.isPresent()) {
            return Optional.empty();
        }

        Dentist mappedDentist = dentistMapper.dentistRequestDtoToDentist(dto);

        Dentist savedDentist = dentistRepository.save(mappedDentist);

        if(dto.appointmentRequestDtos() !=null && !dto.appointmentRequestDtos().isEmpty()) {
            List<Appointment> appointments =  mappedDentist.getAppointments();
            appointments.stream()
                    .map(appointment -> {
                        Optional<Appointment> optionalAppointment = appointmentRepository.findByAppointmentNumber(appointment.getAppointmentNumber());
                        if(optionalAppointment.isPresent()) {
                            Appointment foundAppointment = optionalAppointment.get();
                            appointment.setId(foundAppointment.getId());
                            appointment.setDentist(savedDentist);
                            return appointment;
                        }
                         appointment.setDentist(savedDentist);
                        return appointment;
            }).forEach(appointment -> {
                 AppointmentRequestDto appReq = appointmentMapper.appointmentToAppointmentRequestDto(appointment);
                 appointmentService.createAppointment(appReq, savedDentist, null);
                    });
        }
        return Optional.ofNullable(dentistMapper.dentistToDentistResponseDto(savedDentist));
    }

    @Override
    public List<DentistResponseDto> getAllDentists() {
        List<Dentist> dentists = dentistRepository.findAll();
        return dentistMapper.dentistsToDentistResponseDtos(dentists);
    }

    @Override
    public Optional<DentistResponseDto> getDentistByEmail(String email) {
        Optional<Dentist> optionalDentist = dentistRepository.findByEmail(email);
        if (optionalDentist.isPresent()) {
            Dentist foundDentist = optionalDentist.get();
            return Optional.ofNullable(dentistMapper.dentistToDentistResponseDto(foundDentist));
        }
        return Optional.empty();
    }

    @Override
    public Optional<DentistResponseDto> updateDentist(String email, DentistRequestDto dto) {
        return Optional.empty();
    }

    @Override
    public void deleteDentist(String email) {

    }
}
