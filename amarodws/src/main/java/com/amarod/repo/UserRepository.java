package com.amarod.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarod.model.Customer;
import com.amarod.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
