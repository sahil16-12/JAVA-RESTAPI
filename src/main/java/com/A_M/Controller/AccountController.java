package com.A_M.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.A_M.entities.Account;
import com.A_M.service.AccountServiceImpl;

@RestController
public class AccountController {

	@Autowired
	private AccountServiceImpl service;

	@GetMapping("/FindAccount/{id}")
	public Account Find_Account_Customer(@PathVariable int id) {
		Account a = new Account();
		try {
			a = service.FindAccountCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return a;
	}

	@GetMapping("/MinimumBalance/{min}")
	public List<Account> FindMinBalanceAccount(@PathVariable int min) {

		return service.FindMinBalanceAccount(min);

	}

	@GetMapping("/MaximumBalance/{max}")
	public List<Account> FindMaxBalanceAccount(@PathVariable int max) {
		return service.FindMaxBalanceAccount(max);
	}

	@GetMapping("/BalanceBetween/{min}&{max}")
	 public List<Account> FindRangeBalanceAccount(@PathVariable int min,@PathVariable int max)
	 {
		 return service.FindRangeBalanceAccount(min,max);
	 }

	@GetMapping("/FindAccountsOfCustomer/{name}")
	public ArrayList<ArrayList<Account>> FindAccountByName(@PathVariable String name) {
		return service.FindAccountByName(name);
	}
	
//	@GetMapping("/FindAccountsOfCustomer/{id}")
//	public ArrayList<ArrayList<Account>> FindAccountByName(@PathVariable int id) {
//		return service.FindAccountById(id);
//	}


	@PostMapping("/AddAccount")
	public String AddAccount(@RequestBody Account account) {
		try {
			service.AddAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
			return "There was some problem in creating the Account...";
		}
		return "Account created successfully.";
	}

	@PutMapping("/UpdateAccount")
	public String UpdateAccount(@RequestBody Account account) {
		try {
			if (service.UpdateAccount(account)) {
				return "Account Updation Successful";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "There was some problem in updating the Account...";
	}

	@DeleteMapping("/DeleteAccount/{id}")
	public String DeleteAccount(@PathVariable int id) {
		try {
			service.DeleteAccount(id);
		} catch (Exception e) {
			return "There was some problem in deleting the Account...";
		}
		return "Account deleted sucessfully";
	}
}
