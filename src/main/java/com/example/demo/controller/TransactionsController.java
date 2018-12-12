package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transactions;
import com.example.demo.service.TransactionsService;

@RestController
public class TransactionsController {

	@Autowired
	private TransactionsService tService;

	@GetMapping("/customers/transactions")
	public List<Transactions> findAllTransactions() {
		return tService.getAll();

	}

	@PostMapping("/customers/{customerId}/transactions")
	public Transactions postTransactions(@PathVariable(value = "customerId") Long customerId,
			@Valid @RequestBody Transactions transactions) {
		return tService.creatTransactions(transactions, customerId);

	}

}
