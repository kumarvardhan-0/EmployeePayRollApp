package com.example.employee.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {
    private String name;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	private long salary;
}
