package com.example.employee.service;

import com.example.employee.dto.EmployeePayrollDTO;
import com.example.employee.model.EmployeePayrollData;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeeById(int empId) {
        return repository.findById(empId).orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO dto) {
        EmployeePayrollData emp = new EmployeePayrollData();
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        return repository.save(emp);
    }

    @Override
    public EmployeePayrollData updateEmployee(int empId, EmployeePayrollDTO dto) {
        EmployeePayrollData emp = getEmployeeById(empId);
        if (emp != null) {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
            return repository.save(emp);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int empId) {
        repository.deleteById(empId);
    }
}