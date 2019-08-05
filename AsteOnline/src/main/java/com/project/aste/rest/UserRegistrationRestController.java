package com.project.aste.rest;
import com.project.aste.exception.UserErrorType;
import com.project.aste.entity.AuthenticationData;
import com.project.aste.entity.UserAccount;
import com.project.aste.repository.UserAccountJpaRepository;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
public class UserRegistrationRestController {
	public static final Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);
	private UserAccountJpaRepository userJpaRepository;

	@Autowired
	public void setUserJpaRepository(UserAccountJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}
	
	//metodo get
	@GetMapping("/")
	public ResponseEntity<List<UserAccount>> listAllUsers() {
		List<UserAccount> users = userJpaRepository.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserAccount>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<UserAccount>>(users, HttpStatus.OK);
	}
	//metodo post da rivedere
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccount> createUser(@Valid @RequestBody final UserAccount user) {
		logger.info("Creating User : {}", user);
		if (userJpaRepository.findByName(user.getName()) != null) {
			logger.error("Unable to create. A User with name {} already exist", user.getName());
			return new ResponseEntity<UserAccount>(
					new UserErrorType(
							"Unable to create new user. A username " + user.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		userJpaRepository.save(user);
		return new ResponseEntity<UserAccount>(user, HttpStatus.CREATED);
	}
}
