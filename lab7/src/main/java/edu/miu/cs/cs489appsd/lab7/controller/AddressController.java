package edu.miu.cs.cs489appsd.lab7.controller;

import edu.miu.cs.cs489appsd.lab7.dto.response.AddressWithPatientResponseDto;
import edu.miu.cs.cs489appsd.lab7.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressWithPatientResponseDto>> getAllAddressWithPatient(){
        List<AddressWithPatientResponseDto> addressWithPatient = addressService.getAddressWithPatient();
        return ResponseEntity.status(HttpStatus.OK).body(addressWithPatient);
    }
}
