package com.example.EmployeeDetails.service;

import com.example.EmployeeDetails.model.Employee;
import com.example.EmployeeDetails.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getDetails() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeDetails(String employeeId) {
        return employeeRepo.findByEmployeeId(employeeId);
    }
}
