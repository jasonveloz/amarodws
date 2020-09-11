package com.amarod.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarod.model.Customer;
import com.amarod.model.Information;

public interface InformationRepository extends JpaRepository<Information, Integer> {

	List<Information> findAllByCustomer(Customer customer);
}
