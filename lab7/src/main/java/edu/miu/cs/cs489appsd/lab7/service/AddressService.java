package edu.miu.cs.cs489appsd.lab7.service;

import edu.miu.cs.cs489appsd.lab7.dto.request.AddressRequestDto;
import edu.miu.cs.cs489appsd.lab7.dto.response.AddressResponseDto;
import edu.miu.cs.cs489appsd.lab7.dto.response.AddressWithPatientResponseDto;

import java.util.List;

public interface AddressService {
    AddressResponseDto createAddress(AddressRequestDto addressRequestDto);
    List<AddressResponseDto> getAllAddresses();
    AddressResponseDto getAddressById(long id);
    AddressResponseDto updateAddress(long id, AddressRequestDto addressRequestDto);
    public List<AddressWithPatientResponseDto> getAddressWithPatient();
}
