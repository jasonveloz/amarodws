package com.amarod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amarod.dto.InformationDTO;
import com.amarod.model.Customer;
import com.amarod.model.Information;
import com.amarod.model.KeyValues;
import com.amarod.services.CustomerService;
import com.amarod.services.InformationService;
import com.amarod.services.KeyValueRepository;
import com.amarod.services.KeyValueService;

@CrossOrigin
@RestController
public class InformationController {

	@Autowired
	private InformationService infoService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private KeyValueService keyValueService;

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

	@PostMapping(value = "/customers/{customerId}/informations")
	public ResponseEntity<String> saveInformationToCustomer(@RequestBody InformationDTO infoDTO,
			@PathVariable int customerId) {

		Customer customer = customerService.findById(customerId);
		if (customer == null) {
			return new ResponseEntity<>("CUSTOMER_NOT_FOUND", HttpStatus.OK);
		}

		KeyValues keyValues = keyValueService.findById(infoDTO.getKeyId());
		if (keyValues == null) {
			return new ResponseEntity<>("KEYVALUES_NOT_FOUND", HttpStatus.OK);
		}

		Information newInfo = new Information();
		newInfo.setCustomer(customer);
		newInfo.setKeyValues(keyValues);
		newInfo.setValue(infoDTO.getValue());
		newInfo.setLang(infoDTO.getLang());
		newInfo.setOrderNo(infoDTO.getOrderNo());

		infoService.save(newInfo);
		return new ResponseEntity<>("INFO_SAVED", HttpStatus.OK);
	}

	@DeleteMapping(value = "/informations/{informationId}")
	public ResponseEntity<String> deleteInformationById(@PathVariable("informationId") int informationId) {
		Information information = infoService.findById(informationId);

		if (information == null) {
			return new ResponseEntity<>("INFO_NOT_FOUND", HttpStatus.OK);
		}

		infoService.delete(information);

		return new ResponseEntity<>("INFO_DELETED", HttpStatus.OK);
	}

}
