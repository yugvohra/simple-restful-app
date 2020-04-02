package com.springboot.samples.restfulApp.dto;

import com.springboot.samples.restfulApp.entities.Employee;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class EmployeeList {
    private final List<Employee> employees;
}
