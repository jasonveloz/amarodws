package com.amarod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarod.model.Customer;
import com.amarod.model.Entities;
import com.amarod.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Customer> findAll() {
		return customerRepo.findAll();
	}

	@Override
	public Customer findById(int id) {
		return customerRepo.getOne(id);
	}

	@Override
	public List<Customer> findCustomersByEntity(Entities entity) {
		return customerRepo.findCustomersByEntity(entity);
	}

	@Override
	public void save(Customer customer) {
		customerRepo.save(customer);
	}

}
