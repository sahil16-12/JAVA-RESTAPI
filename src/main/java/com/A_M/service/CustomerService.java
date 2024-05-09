package com.A_M.service;

import java.util.List;

import com.A_M.entities.Customer;

public interface CustomerService {
	public List<Customer> FindAll();

	public Customer FindCustomerDetails(int id);

	public int AddCustomer(Customer customer);

	public boolean  UpdateCustomer(Customer customer);

	public boolean DeleteCustomer(int id);

}
