package com.amarod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarod.model.Entities;
import com.amarod.repo.EntitiesRepository;

@Service
public class EntitiesServiceImpl implements EntitiesService {

	@Autowired
	private EntitiesRepository entitiesRepo;

	@Override
	public List<Entities> findAll() {
		return entitiesRepo.findAll();
	}

	@Override
	public Entities findById(int id) {
		return entitiesRepo.getOne(id);
	}

	@Override
	public void save(Entities entities) {
		entitiesRepo.save(entities);
	}

}
