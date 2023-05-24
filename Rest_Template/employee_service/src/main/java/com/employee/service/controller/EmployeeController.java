package com.employee.service.controller;

import com.employee.service.entity.Employee;
import com.employee.service.response.Response;
import com.employee.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<Response> addEmployee(@RequestBody Employee employee){
        ResponseEntity<Response> response;
        response = employeeService.addEmployee(employee);
        return response;
    }
    @GetMapping("/view/{id}")
    public Employee findEmployeeByID(@PathVariable Long id) throws Exception {
        Employee employee;
        employee = employeeService.findEmployeeById(id);
        List addresses = this.restTemplate.getForObject("http://localhost:8011/address/view/by/user/" + id,
                                                                                                        List.class);
        employee.setAddresses(addresses);
        return employee;
    }
    @GetMapping("/view/all")
    public List<Employee> findEmployees() throws Exception {
        List<Employee> employees;
        employees = employeeService.findEmployees();
        for(Employee employee: employees){
            List addresses = this.restTemplate.getForObject("http://localhost:8011/address/view/by/user/" +
                                                                                        employee.getId(), List.class);
            employee.setAddresses(addresses);
        }
        return employees;
    }
}
