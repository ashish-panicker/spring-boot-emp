package com.example.emp.ng.demo.repo;

import java.util.List;


import com.example.emp.ng.demo.model.Employee;

public interface EmployeeDal {
	
	public Employee create(Employee emp);
	
	public Boolean delete(Employee emp);
	
	public List<Employee> findAll();
	
	public Employee findById(String id);
}
