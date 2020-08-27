package com.amarod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarod.model.KeyValues;

@Service
public class KeyValueServiceImpl implements KeyValueService {
	
	@Autowired
	private KeyValueRepository keyValueRepository;

	@Override
	public List<KeyValues> findAll() {
		return keyValueRepository.findAll();
	}

	@Override
	public KeyValues findById(int keyId) {
		return keyValueRepository.getOne(keyId);
	}

}
