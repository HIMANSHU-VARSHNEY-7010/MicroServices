package com.address.service.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    private String message;
    public Response(String message){
        this.message = message;
    }
}
