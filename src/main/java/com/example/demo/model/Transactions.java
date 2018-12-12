package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "Tansactions")
@JsonIgnoreProperties(value = {"trasaction_date"}, allowGetters = true)
public class Transactions extends DateModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactions_id;
	
	@NotBlank
	private float amount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "trasaction_date",nullable = false,updatable = false)
	@CreatedDate
	private Date trasaction_date;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Customer customer;


	public Long getTransactions_id() {
		return transactions_id;
	}


	public void setTransactions_id(Long transactions_id) {
		this.transactions_id = transactions_id;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public Date getTrasaction_date() {
		return trasaction_date;
	}

	public void setTrasaction_date(Date trasaction_date) {
		this.trasaction_date = trasaction_date;
	}


	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Transactions [transactions_id=" + transactions_id + ", amount=" + amount + ", trasaction_date="
				+ trasaction_date + ", customer=" + customer + "]";
	}
	
}
