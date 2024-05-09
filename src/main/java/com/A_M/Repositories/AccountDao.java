package com.A_M.Repositories;

import java.util.ArrayList;
import java.util.List;

import com.A_M.entities.Account;
import com.A_M.entities.Customer;

import jakarta.persistence.NoResultException;

public interface AccountDao {
	public List<Account> findCustomerAccount(int id);

	public Account FindAccountCustomer(int account);

	public boolean AddAccount(Account account) throws NoResultException;

	public boolean UpdateAccount(Account account) throws NoResultException;

	public boolean DeleteAccount(int id) throws NoResultException;

	public ArrayList<ArrayList<Account>> FindAccountByName(String name);

	public List<Account> FindMinBalanceAccount(int min);

	public List<Account> FindMaxBalanceAccount(int max);
	
	public List<Account> FindRangeBalanceAccount(int min,int max);
	
//	public ArrayList<ArrayList<Account>> FindAccountById(int id);



}
