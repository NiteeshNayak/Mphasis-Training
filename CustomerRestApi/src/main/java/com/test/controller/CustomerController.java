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

import com.test.entity.Customer;
import com.test.service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/customer")
@Tag(name = "Customer CRUD Application")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/create")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer cst){
		Customer obj = service.saveCustomer(cst);
		
		if(obj != null) {
			return new ResponseEntity<Customer>(obj,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Customer>(obj,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> list = service.getAllCustomer();
		
		if(list.size() > 0) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable int id, @RequestBody Customer cst){
		cst.setId(id);
		
		Customer obj = service.updateCustomer(cst);
		
		if(obj != null) {
			return new ResponseEntity<Customer>(obj,HttpStatus.OK);
		}else {
			return new ResponseEntity<Customer>(obj,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Customer>> deleteCustomerById(@PathVariable int id){
		service.deleteCustomerById(id);
		
		List<Customer> list = service.getAllCustomer();
		
		if(list.size() > 0) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Customer>> getById(@PathVariable int id){
		Optional<Customer> obj = service.getCustomerById(id);
		
		if(obj != null) {
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(obj,HttpStatus.BAD_REQUEST);
		}
	}
}
