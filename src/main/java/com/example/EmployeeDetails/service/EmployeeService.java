package com.example.EmployeeDetails.service;

import com.example.EmployeeDetails.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    List<Employee> getDetails();
    Optional<Employee> getEmployeeDetails(String employeeId);
}
