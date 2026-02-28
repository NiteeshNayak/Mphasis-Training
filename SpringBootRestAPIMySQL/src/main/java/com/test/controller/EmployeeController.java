package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.exception.EmployeeNotFoundException;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee/v1/api")
@Tag(name = "Employee Crud Operations")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/create")
	@Operation(summary = "Creating Employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		Employee obj = service.saveEmployee(emp);
		
		if(obj != null) {
			return new ResponseEntity<Employee>(obj, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Employee>(obj, HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> listAllEmployee(){
		List<Employee> list = service.getAllEmployee();
		
		if(list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee emp){
		emp.setId(id);
		Employee obj = service.updateEmployee(emp);
		
		if(obj != null) {
			return new ResponseEntity<Employee>(obj, HttpStatus.OK);
		}else {
			return new ResponseEntity<Employee>(obj, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<List<Employee>> deleteEmployeeById(@PathVariable int id){
		service.deleteEmployeeById(id);
		List<Employee> list = service.getAllEmployee();
		
		if(list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id){
		Optional<Employee> emp = service.getEmployeeById(id);
		
		if(emp != null) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(emp, HttpStatus.NOT_FOUND);
//			throw new EmployeeNotFoundException("No employee with this id");
		}
	}
	
	@GetMapping("/name/{name}")
	@Operation(summary = "get employee by name")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name){
		List<Employee> list = repository.getEmployeeByName(name);
		
		if(list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/company/{company}")
	@Operation(summary = "Getting all the employees who work in same company")
	public ResponseEntity<List<Employee>> getEmployeeByCompany(@PathVariable String company){
		List<Employee> list = repository.getEmployeesByCompanyName(company);
		
		if(list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/sort")
	public ResponseEntity<List<Employee>> getEmployeesInAsc(){
		List<Employee> list = repository.getEmployeesByASC();
		
		if(list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
}
