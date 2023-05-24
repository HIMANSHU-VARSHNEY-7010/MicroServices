package com.address.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED)
public class AddressAlreadyExistException extends RuntimeException {
    public AddressAlreadyExistException(String message) {
        super(message);
    }
}
