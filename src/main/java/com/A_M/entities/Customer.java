package com.A_M.entities;



import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	@Column(name="Customer_id")
	private int cus_id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Address")
	private String address;
	@Temporal(TemporalType.DATE)
	private Date Birth_date;
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirth_date() {
		return Birth_date;
	}
	public void setBirth_date(Date birth_date) {
		Birth_date = birth_date;
	}
	@Override
	public String toString() {
		return "Customer [cus_id=" + cus_id + ", Birth_date=" + Birth_date + "]";
	}

	
	
     
}
