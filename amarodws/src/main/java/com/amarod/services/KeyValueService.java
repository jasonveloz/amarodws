package com.amarod.services;

import java.util.List;

import com.amarod.model.KeyValues;

public interface KeyValueService {
	
	List<KeyValues> findAll();
	
	KeyValues findById(int keyId);

}
