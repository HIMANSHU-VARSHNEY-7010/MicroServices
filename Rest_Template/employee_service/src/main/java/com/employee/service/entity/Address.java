package com.employee.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private Long id;
    private String country;
    private String state;
    private String city;
    private String addressLine;
    private String zipCode;
    @JsonIgnore
    private Long userId;
}
