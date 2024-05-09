package com.A_M.Repositories;

import java.util.ArrayList;
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
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public List<Account> findCustomerAccount(int id) {
		TypedQuery<Account> q = entityManager.createQuery("from Account a where a.customer_id=:id", Account.class);
		q.setParameter("id", id);
		List<Account> account = q.getResultList();
		return account;
	}

	@Transactional
	public Account FindAccountCustomer(int account) {
		TypedQuery<Account> q = entityManager.createQuery("from Account a where a.act_id=:id", Account.class);
		q.setParameter("id", account);
		Account acc = q.getSingleResult();
		return acc;
	}

	@Transactional
	public boolean AddAccount(Account account) throws NoResultException {
		entityManager.merge(account);
		return true;
	}

	@Transactional
	public boolean UpdateAccount(Account account) throws NoResultException {
		int id = account.getAct_id();
		Account acc = entityManager.find(Account.class, id);
		if (acc == null) {
			return false;
		}
		acc.setAccountType(account.getAccountType());
		acc.setBalance(account.getBalance());
		acc.setDate(account.getDate());
		entityManager.merge(acc);
		return true;
	}

	@Transactional
	public boolean DeleteAccount(int id) throws NoResultException {
		Account acc = entityManager.find(Account.class, id);
		entityManager.remove(acc);
		return true;
	}

	@Transactional
	public ArrayList<ArrayList<Account>> FindAccountByName(String name) throws NoResultException {
		TypedQuery<Customer> customer = entityManager.createQuery("from Customer where name=:q", Customer.class);

		customer.setParameter("q", name);
		List<Customer> list = customer.getResultList();
		ArrayList<ArrayList<Account>> acc = new ArrayList<ArrayList<Account>>();
		for (int i = 0; i < list.size(); i++) {
			TypedQuery<Account> q = entityManager.createQuery("From Account where customer=:q ", Account.class);
			q.setParameter("q", list.get(i));
			List<Account> list1 = q.getResultList();
			acc.add(new ArrayList<Account>());
			acc.get(i).addAll(list1);
		}

		return acc;
	}

	@Override
	public List<Account> FindMinBalanceAccount(int min) throws NoResultException {
		TypedQuery<Account> q = entityManager.createQuery("From Account where balance >=:q ", Account.class);
		q.setParameter("q", min);
		List<Account> acc = q.getResultList();
		return acc;
	}

	@Override
	public List<Account> FindMaxBalanceAccount(int max) throws NoResultException {
		TypedQuery<Account> q = entityManager.createQuery("From Account where  balance <=:p", Account.class);
		q.setParameter("p", max);
		List<Account> acc = q.getResultList();
		return acc;
	}

	@Override
	public List<Account> FindRangeBalanceAccount(int min, int max) {
		TypedQuery<Account> q = entityManager.createQuery("From Account where balance >=:p and balance <=:q",
				Account.class);
		q.setParameter("q", max);
		q.setParameter("p", min);
		List<Account> acc = q.getResultList();
		return acc;
	}

//	@Transactional
//	public ArrayList<Account> FindAccountById(int id) throws NoResultException {
//		Customer list = entityManager.find(Customer.class, id);
//
//		ArrayList<ArrayList<Account>> acc = new ArrayList<ArrayList<Account>>();
//
//		TypedQuery<Account> q = entityManager.createQuery("From Account where customer=:q ", Account.class);
//		q.setParameter("q", list);
//		List<Account> list1 = q.getResultList();
//		acc.add(new ArrayList<Account>());
//		acc.get(i).addAll(list1);
//
//		return acc;
//	}

}
