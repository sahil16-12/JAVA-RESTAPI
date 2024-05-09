package com.A_M.entities;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Account {

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name="Account_id")
	private int act_id;
	@Column(name = "Balance")
	private int balance;
	@Column(name = "AccountType")
	private String accountType;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Customer customer;
	
	public int getAct_id() {
		return act_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setAct_id(int act_id) {
		this.act_id = act_id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [act_id=" + act_id + ", balance=" + balance + ", accountType=" + accountType + ", date=" + date
				+ "]";
	}

	
	
	
	
}
