package com.springboot.samples.restfulApp.controllers;

import com.springboot.samples.restfulApp.dto.EmployeeList;
import com.springboot.samples.restfulApp.entities.Employee;
import com.springboot.samples.restfulApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Value("${message: Hello default}")
    private String message;

    @GetMapping("/employee/add")
    public ResponseEntity<String> addEmployee() {
        employeeService.addEmployee(new Employee("random",
                "randomLastName"));
        return ResponseEntity.ok(message);
    }

    @GetMapping("/employee")
    public ResponseEntity<EmployeeList> getAllEmployees() {
        return ResponseEntity.ok(new EmployeeList(employeeService.getAllEmployee()));
    }

}
