package com.amarod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amarod.model.Customer;
import com.amarod.model.Information;
import com.amarod.services.CustomerService;
import com.amarod.services.InformationService;

@CrossOrigin
@RestController
public class InformationController {

	@Autowired
	private InformationService infoService;
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/informations")
	public ResponseEntity<List<Information>> getAllInformations() {
		List<Information> informations = infoService.findAll();
		return new ResponseEntity<>(informations, HttpStatus.OK);
	}

	@GetMapping(value = "/information/{informationId}")
	public ResponseEntity<Information> getInfoByInfoId(@PathVariable int informationId) {
		Information information = infoService.findById(informationId);
		return new ResponseEntity<>(information, HttpStatus.OK);
	}

	@GetMapping(value = "/customers/{customerId}/informations")
	public ResponseEntity<List<Information>> getInformationByCustomer(@PathVariable("customerId") int customerId) {
		Customer customer = customerService.findById(customerId);
		List<Information> listOfInformation = infoService.findInfoByCustomer(customer);
		return new ResponseEntity<List<Information>>(listOfInformation, HttpStatus.OK);
	}

}
