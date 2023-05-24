package com.address.service.service;

import com.address.service.entity.Address;
import com.address.service.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {

    public Address findAddressByID(Long id) throws Exception;
    public ResponseEntity<Response> addAddress(Address address);
    public List<Address> findAddressesByUserId(Long userId);
}
