package com.amarod.services;

import java.util.List;

import com.amarod.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
	
	User findByRecordId(int recordId);
	
	List<User> findAll();

	User saveUser(User user);

	Page<User> findAllWithPagination(Pageable pageable, String search);

	User findByUsername(String username);

}
