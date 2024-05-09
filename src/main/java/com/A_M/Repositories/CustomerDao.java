package com.A_M.Repositories;

import java.util.List;

import com.A_M.entities.Customer;

public interface CustomerDao {
	public List<Customer> FindAll();

	public Customer FindCustomerDetails(int id);

	public int AddCustomer(Customer customer);

	public boolean UpdateCustomer(Customer customer);

	public boolean DeleteCustomer(int id);
}
