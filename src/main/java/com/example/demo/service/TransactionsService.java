package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transactions;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TransactionsRepository;

@Service
public class TransactionsService {

	@Autowired
	private TransactionsRepository transactionsRepository;

	@Autowired
	private CustomerRepository custRepo;

	public List<Transactions> getAll() {
		List<Transactions> tranList = new ArrayList<>();
		tranList = transactionsRepository.findAll();
		return tranList;

	}

	public Transactions creatTransactions(Transactions transactions, long customerId) {
		return custRepo.findById(customerId).map(customer -> {
			transactions.setCustomer(customer);
			return transactionsRepository.save(transactions);
		}).orElseThrow();

	}

}
