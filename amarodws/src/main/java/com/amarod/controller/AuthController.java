package com.amarod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amarod.TokenProvider;
import com.amarod.dto.CustomerDTO;
import com.amarod.dto.LoginDTO;
import com.amarod.model.AuthToken;
import com.amarod.model.Customer;
import com.amarod.model.Entities;
import com.amarod.model.User;
import com.amarod.services.CustomerService;
import com.amarod.services.EntitiesService;
import com.amarod.services.UserService;

@CrossOrigin
@RestController
public class AuthController {

	@Autowired
	private UserService userService;
	@Autowired
	private TokenProvider jwtTokenUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@ResponseBody
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> getAuth(@RequestBody LoginDTO login) throws AuthenticationException {

		User currentUser;

		currentUser = userService.findByUsername(login.getUsername());

		if (currentUser == null) {
			return new ResponseEntity<>("USER_NOT_FOUND", HttpStatus.OK);
		} else {
			if (!currentUser.getUserStatus().equals("ACTIVE")) {
				return new ResponseEntity<>("USER_NOT_ACTIVE", HttpStatus.OK);
			}

		}

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
		return ResponseEntity.ok(new AuthToken(token));
	}

}
