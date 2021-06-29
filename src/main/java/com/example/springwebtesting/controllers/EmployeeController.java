package com.example.springwebtesting.controllers;
import com.example.springwebtesting.data.Employee;
import com.example.springwebtesting.data.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepo;

    public EmployeeController(EmployeeRepository repository) {
        this.employeeRepo = repository;
    }


//    @GetMapping("")
//    public String listAll(Model model) {
//        var emp = (List<Employee>) employeeRepo.findAll();
//        model.addAttribute("listEmployees", emp);
//        return "employees";
//    }

    @GetMapping("")
    public Iterable<Employee> all() {
        return this.employeeRepo.findAll();
    }

    @PostMapping("")
    public Employee create(@RequestBody Employee employee) {
        return this.employeeRepo.save(employee);
    }

}
