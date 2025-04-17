package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AppointmentRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.AppointmentResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper.AppointmentMapper;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.*;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository.AddressRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository.AppointmentRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository.SurgeryRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.AppointmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final SurgeryRepository surgeryRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public Optional<AppointmentResponseDto> createAppointment(AppointmentRequestDto dto) {
        if (appointmentRepository.findByAppointmentNumber(dto.appointmentNumber()).isPresent()) {
            return Optional.empty();
        }

        Appointment mappedAppointment = appointmentMapper.appointmentRequestDtoToAppointment(dto);

        if (dto.surgeryRequestDto() != null) {
            Optional<Surgery> optionalSurgery = surgeryRepository.findBySurgeryNumber(dto.surgeryRequestDto().surgeryNumber());
            if (optionalSurgery.isPresent()) {
                Surgery foundSurgery = optionalSurgery.get();
                mappedAppointment.setSurgery(foundSurgery);

                if (dto.surgeryRequestDto().addressRequestDto() != null) {
                    Optional<Address> optionalAddress = addressRepository.findByUnitNo(dto.surgeryRequestDto().addressRequestDto().unitNo());
                    optionalAddress.ifPresent(foundSurgery::setLocation);
                }
            }
        }

        Appointment savedAppointment = appointmentRepository.save(mappedAppointment);
        return Optional.ofNullable(appointmentMapper.appointmentToAppointmentResponseto(savedAppointment));
    }
    @Override
    @Transactional
    public Optional<AppointmentResponseDto> createAppointment(AppointmentRequestDto dto, Dentist dentist, Patient patient) {
        if (appointmentRepository.findByAppointmentNumber(dto.appointmentNumber()).isPresent()) {
            return Optional.empty();
        }

        Appointment mappedAppointment = appointmentMapper.appointmentRequestDtoToAppointment(dto);

        if (dto.surgeryRequestDto() != null) {
            Optional<Surgery> optionalSurgery = surgeryRepository.findBySurgeryNumber(dto.surgeryRequestDto().surgeryNumber());
            if (optionalSurgery.isPresent()) {
                Surgery foundSurgery = optionalSurgery.get();
                mappedAppointment.setSurgery(foundSurgery);

                if (dto.surgeryRequestDto().addressRequestDto() != null) {
                    Optional<Address> optionalAddress = addressRepository.findByUnitNo(dto.surgeryRequestDto().addressRequestDto().unitNo());
                    optionalAddress.ifPresent(foundSurgery::setLocation);
                }
            }
        }

        if (dentist != null) {
            mappedAppointment.setDentist(dentist);
        }
        if (patient != null) {
            mappedAppointment.setPatient(patient);
        }

        Appointment savedAppointment = appointmentRepository.save(mappedAppointment);
        return Optional.ofNullable(appointmentMapper.appointmentToAppointmentResponseto(savedAppointment));
    }
    @Override
    public List<AppointmentResponseDto> getAllAppointments() {
        return appointmentMapper.appointmentsToAppointmentResponsetos(appointmentRepository.findAll());
    }

    @Override
    public Optional<AppointmentResponseDto> getAppointmentByAppointmentNumber(String appointmentNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<AppointmentResponseDto> updateAppointment(String appointmentNumber, AppointmentRequestDto dto) {
        return Optional.empty();
    }

    @Override
    public void deleteAppointment(Long id) {

    }
}
