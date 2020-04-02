package com.springboot.samples.restfulApp.repositories;

import com.springboot.samples.restfulApp.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeMongoRepository extends MongoRepository<Employee, String> {
    List<Employee> findByLastName(String lastName);

    Employee findById(long id);
}
