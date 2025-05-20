package com.example.employee.service;

import com.example.employee.dto.EmployeePayrollDTO;
import com.example.employee.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private List<EmployeePayrollData> employeeList = new ArrayList<>();
    private int currentId = 1;

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeList;
    }

    @Override
    public EmployeePayrollData getEmployeeById(int empId) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == empId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO dto) {
        EmployeePayrollData emp = new EmployeePayrollData(currentId++, dto.getName(), dto.getSalary());
        employeeList.add(emp);
        return emp;
    }

    @Override
    public EmployeePayrollData updateEmployee(int empId, EmployeePayrollDTO dto) {
        EmployeePayrollData emp = getEmployeeById(empId);
        if (emp != null) {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
        }
        return emp;
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeList.removeIf(emp -> emp.getId() == empId);
    }
}