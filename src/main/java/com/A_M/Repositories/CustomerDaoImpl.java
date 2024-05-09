package com.A_M.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.A_M.entities.Account;
import com.A_M.entities.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Customer> FindAll() {

		TypedQuery<Customer> query = entityManager.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		System.out.println(customers);
		return customers;
	}

	@Override
	@Transactional
	public Customer FindCustomerDetails(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

	@Override
	@Transactional
	public int AddCustomer(Customer customer) {
		entityManager.merge(customer);
		return customer.getCus_id();
	}

	@Override
	@Transactional
	public boolean UpdateCustomer(Customer customer) {
		Customer cus = entityManager.find(Customer.class, customer.getCus_id());
		if (cus == null) {
			return false;
		}
		cus.setAddress(customer.getAddress());
		cus.setBirth_date(customer.getBirth_date());
		cus.setName(customer.getName());
		entityManager.merge(cus);
		return true;
	}

	@Override
	@Transactional
	public boolean DeleteCustomer(int id) throws NoResultException {
		Customer customer = entityManager.find(Customer.class, id);
	    if (customer == null) {
	        throw new NoResultException("Customer with id " + id + " not found");
	    }
		TypedQuery<Account> acc = entityManager.createQuery("from Account where customer=:q", Account.class);
		acc.setParameter("q", customer);
		List<Account> list = acc.getResultList();
		for(Account a: list) {
			entityManager.remove(a);
		}
		Customer cus = entityManager.find(Customer.class, id);
		entityManager.remove(cus);
		return true;
	}
}
