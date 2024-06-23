package com.example.EmployeeDetails.controller;

import com.example.EmployeeDetails.model.Employee;
import com.example.EmployeeDetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showForm(Model model) {
        return "index";
    }

    @GetMapping("/newEmployee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping("/createEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/api/displayAll";
    }

    @GetMapping("/displayAll")
    public String getDetails(Model model) {
        List<Employee> employees = employeeService.getDetails();
        model.addAttribute("employees", employees);
        return "employee-details";
    }

    @GetMapping("/search")
    public String searchEmployeeForm() {
        return "search-form";
    }
    @GetMapping("/display")
    public String getEmployeeDetailsById(@RequestParam String employeeId, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeDetails(employeeId);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "search-by-id";
        } else {
            return "id-not-found";
        }
    }
    @GetMapping("/display/{employeeId}")
    public String getEmployeeDetails(@PathVariable String employeeId, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeDetails(employeeId);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "search-by-id";
        } else {
            return "id-not-found";
        }
    }
}
