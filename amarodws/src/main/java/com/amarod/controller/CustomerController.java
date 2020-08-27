package com.amarod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amarod.dto.CustomerDTO;
import com.amarod.model.Customer;
import com.amarod.model.Entities;
import com.amarod.services.CustomerService;
import com.amarod.services.EntitiesService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private EntitiesService entitiesService;

	@CrossOrigin
	@GetMapping(value = "/customers")
	public List<Customer> getCustomer() {
		List<Customer> list = customerService.findAll();
		return list;
	}

	@CrossOrigin
	@GetMapping(value = "/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return customerService.findById(id);
	}

	@CrossOrigin
	@GetMapping(value = "/entities/{entityId}/customers")
	public ResponseEntity<List<?>> getCustomersByEntityId(@PathVariable int entityId) {

		Entities entity = entitiesService.findById(entityId);
		if (entity == null) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}

		List<Customer> listOfCustomers = customerService.findCustomersByEntity(entity);
		return new ResponseEntity<>(listOfCustomers, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "/customers")
	public ResponseEntity<String> save(@RequestBody CustomerDTO customerDTO) {

		Entities entity = entitiesService.findById(customerDTO.getEntity());

		if (entity == null) {
			return new ResponseEntity<String>("ENTITY_NOT_FOUND", HttpStatus.OK);
		}

		Customer newCustomer = new Customer();
		newCustomer.setCustomerName(customerDTO.getCustomerName());
		newCustomer.setCustomerCode(customerDTO.getCustomerCode());
		newCustomer.setDescription(customerDTO.getDescription());
		newCustomer.setEntity(entity);
		newCustomer.setImg(customerDTO.getImg());
		newCustomer.setLang(customerDTO.getLang());
		newCustomer.setOrderNo(customerDTO.getOrderNo());
		customerService.save(newCustomer);

		return new ResponseEntity<String>("CUSTOMER_CREATED", HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping(value = "/customers/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {

		// Find if this Customer exists
		Customer currentCustomer = customerService.findById(id);
		if (currentCustomer == null) {
			return new ResponseEntity<String>("CUSTOMER_NOT_FOUND", HttpStatus.OK);
		}

		// Found Entity
		Entities entity = entitiesService.findById(customerDTO.getEntity());
		if (entity == null) {
			return new ResponseEntity<String>("ENTITY_NOT_FOUND", HttpStatus.OK);
		}

		currentCustomer.setCustomerName(customerDTO.getCustomerName());
		currentCustomer.setCustomerCode(customerDTO.getCustomerCode());
		currentCustomer.setDescription(customerDTO.getDescription());
		currentCustomer.setEntity(entity);
		currentCustomer.setImg(customerDTO.getImg());
		currentCustomer.setLang(customerDTO.getLang());
		currentCustomer.setOrderNo(customerDTO.getOrderNo());
		customerService.save(currentCustomer);

		return new ResponseEntity<String>("CUSTOMER_UPDATED", HttpStatus.CREATED);
	}

}
