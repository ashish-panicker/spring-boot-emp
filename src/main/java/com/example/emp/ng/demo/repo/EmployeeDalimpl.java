package com.example.emp.ng.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.emp.ng.demo.model.Employee;

@Repository
public class EmployeeDalimpl implements EmployeeDal{

	@Autowired
	private MongoTemplate mongo;

	@Override
	public Employee create(Employee emp) {
		// TODO Auto-generated method stub
		return mongo.save(emp);
	}

	@Override
	public Boolean delete(Employee emp) {
		// TODO Auto-generated method stub
		return mongo.remove(emp).wasAcknowledged();
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Employee.class);
	}

	@Override
	public Employee findById(String id) {
		// TODO Auto-generated method stub
		return mongo.findAndRemove(new Query(Criteria.where("id").is(id)), Employee.class);
	}
}
