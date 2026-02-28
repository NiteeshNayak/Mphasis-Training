package com.test.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private CustomerRepository repo;
	@Override
	public Customer saveCustomer(Customer cst) {
		
		return repo.save(cst);
	}

	@Override
	public Customer updateCustomer(Customer cst) {
	
		return repo.save(cst);
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return repo.findAll();
	}

	@Override
	public List<Customer> deleteCustomerById(int id) {
		repo.deleteById(id);
		return repo.findAll();
	}

}
