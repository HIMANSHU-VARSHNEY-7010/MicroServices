package com.address.service.controller;

import com.address.service.entity.Address;
import com.address.service.response.Response;
import com.address.service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity<Response> addAddress(@RequestBody Address address){
        ResponseEntity<Response> response;
        response = addressService.addAddress(address);
        return response;
    }
    @GetMapping("/view/{id}")
    public Address findAddressByID(@PathVariable Long id) throws Exception {
        Address address;
        address = addressService.findAddressByID(id);
        return address;
    }
    @GetMapping("/view/by/user/{userId}")
    public List<Address> findAddressesByUserId(@PathVariable Long userId) {
        List<Address> addresses;
        addresses = addressService.findAddressesByUserId(userId);
        return addresses;
    }
}
