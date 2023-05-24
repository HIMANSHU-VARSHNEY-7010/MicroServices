package com.employee.service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeIdGenerator")
    @SequenceGenerator(name = "employeeIdGenerator", sequenceName = "employeeIdSequence", initialValue = 1,
                                                                                                allocationSize = 1)
    private Long id;
    private String name;
    private String phoneNo;
    @Transient
    private List<Address> addresses = new ArrayList<>();

    public Employee(String name, String phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
    }
}
