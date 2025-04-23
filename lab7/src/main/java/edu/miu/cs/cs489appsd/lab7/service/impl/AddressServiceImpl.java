package edu.miu.cs.cs489appsd.lab7.service.impl;

import edu.miu.cs.cs489appsd.lab7.dto.request.AddressRequestDto;
import edu.miu.cs.cs489appsd.lab7.dto.response.AddressResponseDto;
import edu.miu.cs.cs489appsd.lab7.dto.response.AddressWithPatientResponseDto;
import edu.miu.cs.cs489appsd.lab7.exception.NotFoundException;
import edu.miu.cs.cs489appsd.lab7.mapper.AddressMapper;
import edu.miu.cs.cs489appsd.lab7.mapper.AddressPatientMapper;
import edu.miu.cs.cs489appsd.lab7.model.Address;
import edu.miu.cs.cs489appsd.lab7.repository.AddressRepository;
import edu.miu.cs.cs489appsd.lab7.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final AddressPatientMapper addressPatientMapper;

    @Override
    public AddressResponseDto createAddress(AddressRequestDto addressRequestDto) {
       Address savedAddress =  addressRepository.save(addressMapper.addressRequestDtoToAddress(addressRequestDto));
       return addressMapper.addressToAddressResponseDto(savedAddress);
    }

    @Override
    public List<AddressResponseDto> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return  addressMapper.addressListToAddressResponseDtoList(addresses);
    }

    @Override
    public AddressResponseDto getAddressById(long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()) {
            return addressMapper.addressToAddressResponseDto(optionalAddress.get());
        }else {
            throw new NotFoundException("Address with id " +id + " doesn't exist");
        }
    }

    @Override
    public AddressResponseDto updateAddress(long id, AddressRequestDto addressRequestDto) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()) {
            Address foundAddress = optionalAddress.get();
            foundAddress.setUnitNo(addressRequestDto.unitNo());
            foundAddress.setCity(addressRequestDto.city());
            foundAddress.setCity(addressRequestDto.city());
            foundAddress.setState(addressRequestDto.state());
            foundAddress.setZip(addressRequestDto.zip());
            Address updatedAddress = addressRepository.save(foundAddress);
            return addressMapper.addressToAddressResponseDto(updatedAddress);
        }else {
            throw new NotFoundException("Address with id " +id + " doesn't exist");
        }
    }

    @Override
    public List<AddressWithPatientResponseDto> getAddressWithPatient(){
        List<Address> addresses = addressRepository.findAll();
        addresses.sort(Comparator.comparing(Address::getCity));
        return addressPatientMapper.addressListToAddressWithPatientDtoList(addresses) ;
    }
}
