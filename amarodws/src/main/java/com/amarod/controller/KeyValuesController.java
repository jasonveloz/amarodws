package com.amarod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amarod.model.KeyValues;
import com.amarod.services.KeyValueService;

@CrossOrigin
@RestController
public class KeyValuesController {

	@Autowired
	private KeyValueService keyValueService;

	@GetMapping(value = "/keyvalues")
	public ResponseEntity<List<KeyValues>> getAllKeyValues() {
		List<KeyValues> keyValues = keyValueService.findAll();
		return new ResponseEntity<>(keyValues, HttpStatus.OK);
	}

	@GetMapping(value = "/keyvalues/{keyId}")
	public ResponseEntity<KeyValues> getKeyValueByKeyId(@PathVariable int keyId) {
		KeyValues keyValue = keyValueService.findById(keyId);
		return new ResponseEntity<>(keyValue, HttpStatus.OK);
	}


}
