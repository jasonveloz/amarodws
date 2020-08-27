package com.amarod.services;

import java.util.List;

import com.amarod.model.Customer;
import com.amarod.model.Entities;

public interface CustomerService {

	List<Customer> findAll();

	Customer findById(int id);

	List<Customer> findCustomersByEntity(Entities entity);
	
	void save(Customer customer);

}
