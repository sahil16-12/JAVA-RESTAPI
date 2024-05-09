package com.A_M.service;

import java.util.ArrayList;
import java.util.List;

import com.A_M.entities.Account;

public interface AccountService {
	public List<Account> findCustomerAccount(int id);

	public List<Account> FindMinBalanceAccount(int min);

	public Account FindAccountCustomer(int account);

	public boolean AddAccount(Account account);

	public boolean UpdateAccount(Account account);

	public boolean DeleteAccount(int id);

	public ArrayList<ArrayList<Account>> FindAccountByName(String name);

	public List<Account> FindMaxBalanceAccount(int max);

	public List<Account> FindRangeBalanceAccount(int min, int max);
	
//	public ArrayList<ArrayList<Account>> FindAccountById(int id);

}
