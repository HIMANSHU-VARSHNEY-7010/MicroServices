package com.address.service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressIdGenerator")
    @SequenceGenerator(name = "addressIdGenerator", sequenceName = "addressIdSequence", initialValue = 1,
            allocationSize = 1)
    private Long id;
    private String country;
    private String state;
    private String city;
    private String addressLine;
    private String zipCode;
    private Long userId;
}
