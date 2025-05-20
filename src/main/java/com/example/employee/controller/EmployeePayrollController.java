package com.example.employee.controller;

import com.example.employee.dto.EmployeePayrollDTO;
import com.example.employee.model.EmployeePayrollData;
import com.example.employee.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService service;

    @GetMapping
    public List<EmployeePayrollData> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeePayrollData getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public EmployeePayrollData createEmployee(@RequestBody EmployeePayrollDTO dto) {
        return service.createEmployee(dto);
    }

    @PutMapping("/{id}")
    public EmployeePayrollData updateEmployee(@PathVariable int id, @RequestBody EmployeePayrollDTO dto) {
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Deleted employee with ID: " + id;
    }
}