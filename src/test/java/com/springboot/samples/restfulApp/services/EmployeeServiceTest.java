package com.springboot.samples.restfulApp.services;

import com.springboot.samples.restfulApp.entities.Employee;
import com.springboot.samples.restfulApp.repositories.EmployeeMongoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceTest {

    @MockBean
    private EmployeeMongoRepository employeeMongoRepository;

    @Autowired
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        when(employeeMongoRepository.findAll()).thenReturn(List.of(new Employee("Alex", "Goodwin"), new Employee("james", "good")));
    }

    @Test
    public void should_returnAllEmployee_when_queried() {
        //Arrange

        //Act
        List<Employee> employees = employeeService.getAllEmployee();

        //Assert
        assertThat(employees).hasSize(2);
        assertThat(employees).contains(new Employee("Alex", "Goodwin"));
    }

    @Test
    public void should_be_able_to_addEmployee() {
        //Arrange

        //Act
        Employee employee = new Employee("Alex", "Baldwin");
        employeeService.addEmployee(employee);

        //Assert
        verify(employeeMongoRepository).save(employee);
    }
}