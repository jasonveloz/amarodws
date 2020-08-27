package com.amarod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarod.model.Information;
import com.amarod.repo.InformationRepository;

@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	private InformationRepository infoRepository;

	@Override
	public Information findById(int infoId) {
		return infoRepository.getOne(infoId);
	}

	@Override
	public List<Information> findInfoByCustomer(int customer) {
		return infoRepository.findAllByCustomer(customer);
	}

	@Override
	public List<Information> findAll() {
		return infoRepository.findAll();
	}

}
