package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.impl;

import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.AppointmentRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.DentistRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.request.PatientRequestDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.DentistResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.dto.response.PatientResponseDto;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper.AppointmentMapper;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper.PatientMapper;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.mapper.SurgeryMapper;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Appointment;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Dentist;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.model.Patient;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository.AppointmentRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.repository.PatientRepository;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.AppointmentService;
import edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientMapper patientMapper;
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @Override
    public Optional<PatientResponseDto> createPatient(PatientRequestDto dto) {
        Optional<Patient> optionalPatient = patientRepository.findByEmail(dto.email());
        if (optionalPatient.isPresent()) {
            return Optional.empty();
        }

        Patient mappedPatient = patientMapper.patientRequestDtoToPatient(dto);

        Patient savedPatient= patientRepository.save(mappedPatient);

        if(dto.appointmentRequestDtos() !=null && !dto.appointmentRequestDtos().isEmpty()) {
            List<Appointment> appointments =  mappedPatient.getAppointments();
            appointments.stream()
                    .map(appointment -> {
                        Optional<Appointment> optionalAppointment = appointmentRepository.findByAppointmentNumber(appointment.getAppointmentNumber());
                        if(optionalAppointment.isPresent()) {
                            Appointment foundAppointment = optionalAppointment.get();
                            appointment.setId(foundAppointment.getId());
                            appointment.setPatient(savedPatient);
                            return appointment;
                        }
                        appointment.setPatient(savedPatient);
                        return appointment;
                    }).forEach(appointment -> {
                        AppointmentRequestDto appReq = appointmentMapper.appointmentToAppointmentRequestDto(appointment);
                        appointmentService.createAppointment(appReq, null, savedPatient);
                    });
        }
        return Optional.ofNullable(patientMapper.patientToPatientResponseDto(savedPatient));
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        return List.of();
    }

    @Override
    public Optional<PatientResponseDto> getPatientByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<PatientResponseDto> updatePatient(Long id, PatientRequestDto dto) {
        return Optional.empty();
    }

    @Override
    public void deletePatient(Long id) {

    }
}
