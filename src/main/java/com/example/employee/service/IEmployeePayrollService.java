package com.example.employee.service;

import com.example.employee.dto.EmployeePayrollDTO;
import com.example.employee.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getAllEmployees();
    EmployeePayrollData getEmployeeById(int empId);
    EmployeePayrollData createEmployee(EmployeePayrollDTO dto);
    EmployeePayrollData updateEmployee(int empId, EmployeePayrollDTO dto);
    void deleteEmployee(int empId);
}
