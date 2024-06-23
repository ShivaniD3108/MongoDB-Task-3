package com.example.EmployeeDetails.repo;

import com.example.EmployeeDetails.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
    Optional<Employee> findByEmployeeId(String employeeId);
}
