package com.amarod.services;

import java.util.List;

import com.amarod.model.Entities;

public interface EntitiesService {

	List<Entities> findAll();

	Entities findById(int id);

	void save(Entities entities);

}
