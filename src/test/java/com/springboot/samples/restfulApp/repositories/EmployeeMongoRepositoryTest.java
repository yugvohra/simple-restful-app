package com.springboot.samples.restfulApp.repositories;

import com.springboot.samples.restfulApp.entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class EmployeeMongoRepositoryTest {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private EmployeeMongoRepository employeeMongoRepository;

    @AfterEach
    public void clearCollections(){
        mongoTemplate.dropCollection(Employee.class);
    }

    @Test
    public void should_findAllEmployee_whenEmplyeeArePresent() {
        //Arrange
        Employee employeeAlex = new Employee("Alex", "GoodWin");
        Employee employeeBob = new Employee("Bob", "Frost");
        Employee employeeYug = new Employee("Yug", "Vohra");
        mongoTemplate.save(employeeAlex);
        mongoTemplate.save(employeeBob);
        mongoTemplate.save(employeeYug);

        //Act
        List<Employee> employees = employeeMongoRepository.findAll();

        //Assert
        assertThat(employees).hasSize(3);
        assertThat(employees).contains(employeeBob);
    }

    @Test
    public void should_findEmployee_byLastName() {
        //Arrange
        Employee employeeAlex = new Employee("Alex", "GoodWin");
        Employee employeeBob = new Employee("Bob", "Frost");
        Employee employeeYug = new Employee("Yug", "Vohra");
        mongoTemplate.save(employeeAlex);
        mongoTemplate.save(employeeBob);
        mongoTemplate.save(employeeYug);

        //Act
        List<Employee> employees = employeeMongoRepository.findByLastName("Vohra");

        //Assert
        assertThat(employees).hasSize(1);
        assertThat(employees).contains(employeeYug);
    }
}
