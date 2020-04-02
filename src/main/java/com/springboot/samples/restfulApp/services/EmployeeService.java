package com.springboot.samples.restfulApp.services;

import com.springboot.samples.restfulApp.entities.Employee;
import com.springboot.samples.restfulApp.repositories.EmployeeMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMongoRepository employeeMongoRepository;

    public void addEmployee(Employee employee) {
        employeeMongoRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeMongoRepository.findAll();
    }
}
