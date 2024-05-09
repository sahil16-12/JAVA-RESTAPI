package com.A_M.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.A_M.Repositories.AccountDaoImpl;
import com.A_M.entities.Account;

import jakarta.persistence.NoResultException;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDaoImpl Adao;

	@Override
	public List<Account> findCustomerAccount(int id) {
		return this.Adao.findCustomerAccount(id);
	}

	@Override
	public List<Account> FindMinBalanceAccount(int min) throws NoResultException {
		return Adao.FindMinBalanceAccount(min);
	}

	@Override
	public Account FindAccountCustomer(int account) throws NoResultException {
		return this.Adao.FindAccountCustomer(account);
	}

	@Override
	public boolean AddAccount(Account account) throws NoResultException {
		return this.Adao.AddAccount(account);
	}

	@Override
	public boolean UpdateAccount(Account account) throws NoResultException {
		return this.Adao.UpdateAccount(account);
	}

	@Override
	public boolean DeleteAccount(int id) throws NoResultException {
		return this.Adao.DeleteAccount(id);
	}

	public ArrayList<ArrayList<Account>> FindAccountByName(String name) throws NoResultException {
		return Adao.FindAccountByName(name);
	}

	@Override
	public List<Account> FindMaxBalanceAccount(int max) throws NoResultException {
		return Adao.FindMaxBalanceAccount(max);
	}

	@Override
	 public List<Account> FindRangeBalanceAccount(int min,int max)
	 {
		 return Adao.FindRangeBalanceAccount(min,max);
	 }

//	@Override
//	public ArrayList<ArrayList<Account>> FindAccountById(int id) {
//		return Adao.FindAccountById(id);
//	}

}
