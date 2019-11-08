package com.example.emp.ng.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.ng.demo.model.Employee;
import com.example.emp.ng.demo.repo.EmployeeDal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IndexController {
	
	@Autowired
	private EmployeeDal empDal;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		return empDal.findAll();
	}

	@DeleteMapping(path = { "/employees/{id}" })
	public Employee delete(@PathVariable("id") String id) {
		System.out.println("id " + id);
		Employee deletedEmp = empDal.findById(id);
		System.out.println(deletedEmp);
		if(empDal.delete(deletedEmp))
			return deletedEmp;
		else
			return null;
	}

	@PostMapping("/employees")
	public Employee create(@RequestBody Employee user) {
		empDal.create(user);
		System.out.println(user + " insert");
		return user;
	}

}
