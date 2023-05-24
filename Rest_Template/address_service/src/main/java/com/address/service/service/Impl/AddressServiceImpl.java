package com.address.service.service.Impl;

import com.address.service.entity.Address;
import com.address.service.exception.AddressAlreadyExistException;
import com.address.service.exception.AddressNotFoundException;
import com.address.service.repository.AddressRepository;
import com.address.service.service.AddressService;
import com.address.service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findAddressByID(Long id) throws Exception {
        Address address;
        address = addressRepository.findById(id).orElseThrow(() ->
                                    new AddressNotFoundException("Address with id: " + id + " not Found."));
        return address;
    }

    @Override
    public ResponseEntity<Response> addAddress(Address address) {
        if(Objects.nonNull(address.getId())){
            Address add = addressRepository.findById(address.getId()).orElse(null);
            if(Objects.nonNull(add))
                throw new AddressAlreadyExistException("Address with id: " + address.getId() + " already exist.");
        }
        else addressRepository.save(address);
        return new ResponseEntity<>(new Response("Address details added to address table in the Database."),
                                                                                                HttpStatus.CREATED);
    }
    public List<Address> findAddressesByUserId(Long userId){
        List<Address> addresses;
        addresses = addressRepository.findByUserId(userId);
        return addresses;
    }
}
