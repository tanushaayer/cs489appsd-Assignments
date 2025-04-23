package edu.miu.cs.cs489appsd.lab7.controller;

import edu.miu.cs.cs489appsd.lab7.dto.request.PatientRequestDto;
import edu.miu.cs.cs489appsd.lab7.dto.response.PatientResponseDto;
import edu.miu.cs.cs489appsd.lab7.model.Patient;
import edu.miu.cs.cs489appsd.lab7.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatients() {
        List<PatientResponseDto> patients = patientService.getAllPatients();
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patient = patientService.createPatient(patientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable long id) {
        PatientResponseDto patient = patientService.getPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable long id, @RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patient = patientService.updatePatient(id, patientRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PatientResponseDto> deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<PatientResponseDto>> searchPatient(@PathVariable String searchString) {
        List<PatientResponseDto> result = patientService.searchPatients(searchString);
        return ResponseEntity.ok(result);
    }

}
