package com.example.EmployeeDetails.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "employee")
public class Employee {
    @Id
    private String id; // Renamed from _id to id
    private String employeeId;
    private String employeeName;
    private String employeeMail;
    private String employeeLoc;
}
