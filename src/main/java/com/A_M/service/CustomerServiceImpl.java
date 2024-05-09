package com.A_M.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.A_M.Repositories.CustomerDaoImpl;
import com.A_M.entities.Customer;

import jakarta.persistence.NoResultException;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDaoImpl Cdao;

	public List<Customer> FindAll() throws NoResultException{
		return this.Cdao.FindAll();
	}

	public Customer FindCustomerDetails(int id) throws NoResultException{
		return this.Cdao.FindCustomerDetails(id);
	}

	public int AddCustomer(Customer customer) throws NoResultException {
		return this.Cdao.AddCustomer(customer);
	}

	public boolean UpdateCustomer(Customer customer) throws NoResultException {
		return this.Cdao.UpdateCustomer(customer);
	}

	public boolean DeleteCustomer(int id) throws NoResultException {
		try {
			Cdao.DeleteCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
