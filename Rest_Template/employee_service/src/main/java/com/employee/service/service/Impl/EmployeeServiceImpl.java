package com.employee.service.service.Impl;

import com.employee.service.entity.Employee;
import com.employee.service.exception.EmployeeAlreadyExistException;
import com.employee.service.exception.EmployeeNotFoundException;
import com.employee.service.repository.EmployeeRepository;
import com.employee.service.response.Response;
import com.employee.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeById(Long id) throws Exception {
        Employee employee;
        employee = employeeRepository.findById(id).orElseThrow(() ->
                                    new EmployeeNotFoundException("Employee with id: " + id + " not Found."));
        return employee;
    }

    @Override
    public ResponseEntity<Response> addEmployee(Employee employee) {
        if(Objects.nonNull(employee.getId())){
            Employee emp = employeeRepository.findById(employee.getId()).orElse(null);
            if(Objects.nonNull(emp))
                throw new EmployeeAlreadyExistException("Employee with id: " + employee.getId() + " already exist.");
        }
        else employeeRepository.save(employee);
        return new ResponseEntity<>(new Response("Employee details added to employee table in the Database."),
                                                                                                HttpStatus.CREATED);
    }

    @Override
    public List<Employee> findEmployees() throws Exception {
        List<Employee> employees;
        employees = employeeRepository.findAll();
        if(employees.isEmpty()){
            throw new EmployeeNotFoundException("Employees not Found.");
        }
        return employees;
    }
}
