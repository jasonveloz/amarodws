package com.amarod.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarod.model.Customer;
import com.amarod.model.Entities;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findCustomersByEntity(Entities entity);

}
