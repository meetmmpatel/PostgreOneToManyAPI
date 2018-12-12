package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository custRepo;

	
	// this method is for get all list of customers
	public List<Customer> getCustList() {

		List<Customer> list = new ArrayList<>();
		list = custRepo.findAll();
		return list;
	}
	
	//This method is for get one customer
	
	public Optional<Customer> getOne(Long id) {
		return custRepo.findById(id);
	}
	
	//This method is for Post or insert the new customer
	public Customer createCustomer(Customer customer) {
		return custRepo.save(customer);
	}
	
	
	//This method is for Updated of existing customer
	
	public Customer updateOne(Customer customer, Long id) {
		return custRepo.save(customer);
	}

}
