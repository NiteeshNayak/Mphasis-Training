package com.test.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.EmployeeDao;
import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EmployeeRepository empRepo;
	
	
	@Override
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return empRepo.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}
	
	@Override
	public List<Employee> deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		return empRepo.findAll();
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}
