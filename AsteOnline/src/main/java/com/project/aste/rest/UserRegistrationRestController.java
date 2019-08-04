package com.project.aste.rest;
import com.project.aste.exception.UserErrorType;
import com.project.aste.entity.AuthenticationData;
import com.project.aste.repository.UserJpaRepository;


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
@RequestMapping("/api/user")
public class UserRegistrationRestController {
	public static final Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);
	private UserJpaRepository userJpaRepository;

	@Autowired
	public void setUserJpaRepository(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AuthenticationData>> listAllUsers() {
		List<AuthenticationData> users = userJpaRepository.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<AuthenticationData>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<AuthenticationData>>(users, HttpStatus.OK);
	}
	
//	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AuthenticationData> createUser(@Valid @RequestBody final AuthenticationData user) {
//		logger.info("Creating User : {}", user);
//		if (userJpaRepository.findByName(user.getUsername()) != null) {
//			logger.error("Unable to create. A User with name {} already exist", user.getUsername());
//			return new ResponseEntity<AuthenticationData>(
//					new UserErrorType(
//							"Unable to create new user. A username " + user.getUsername() + " already exist."),
//					HttpStatus.CONFLICT);
//		}
//		userJpaRepository.save(user);
//		return new ResponseEntity<AuthenticationData>(user, HttpStatus.CREATED);
//	}
}
