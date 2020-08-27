package com.amarod.services;

import com.amarod.dto.UserDTO;
import com.amarod.model.User;
import com.amarod.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getUserStatus().equals("ACTIVE"), true, true, true, getAuthority(user));
	}

	public Set<GrantedAuthority> getAuthority(User user) {
		Set authorities = new HashSet<>();

		// user.getRoles().forEach(role -> {
		// authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		// authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		// });
		authorities.add(new SimpleGrantedAuthority("ROLE_NEW"));
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return authorities;
	}

	@Override
	public User findByRecordId(int recordId) {
		return userRepository.findById(recordId).get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Page<User> findAllWithPagination(Pageable pageable, String search) {
		return userRepository.findAll(pageable);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
