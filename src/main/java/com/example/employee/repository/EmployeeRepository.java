package com.example.employee.repository;

import com.example.employee.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeePayrollData, Integer> {
}