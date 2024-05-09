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

import com.A_M.entities.Customer;
import com.A_M.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceImpl service;

	@GetMapping("/FindAllCustomers")
	public List<Customer> FindAll() {
		List<Customer> c = new ArrayList<>();
		try {
			c = this.service.FindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@GetMapping("/FindCustomer/{id}")
	public Customer Find_Customer_Details(@PathVariable int id) {
		Customer c = new Customer();
		try {
			c = service.FindCustomerDetails(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@PostMapping("/AddCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		try {
			this.service.AddCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return "There was some problem in creating the Customer...";
		}
		return "Customer added successfully";

	}

	@PutMapping("/UpdateCustomer")
	public String UpdateCustomer(@RequestBody Customer customer) {
		try {
		if (service.UpdateCustomer(customer)) {
			return "Customer Updation Sucessfull";
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "There was some problem in updating the Customer...";
	}

	@DeleteMapping("/DeleteCustomer/{id}")
	public String DeleteCustomer(@PathVariable int id) {
		try {
		if (service.DeleteCustomer(id)) {
			return "Cusomer deleted sucessfully";
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "There was some problem in dreating the Customer...";
	}
}
