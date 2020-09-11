package com.amarod.services;

import java.util.List;

import com.amarod.model.Customer;
import com.amarod.model.Information;

public interface InformationService {

	List<Information> findAll();

	Information findById(int infoId);

	List<Information> findInfoByCustomer(Customer entity);

}
