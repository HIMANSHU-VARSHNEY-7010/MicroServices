package com.employee.service.service;

import com.employee.service.entity.Employee;
import com.employee.service.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    public Employee findEmployeeById(Long id) throws Exception;
    public ResponseEntity<Response> addEmployee(Employee employee);
    public List<Employee> findEmployees() throws Exception;
}
