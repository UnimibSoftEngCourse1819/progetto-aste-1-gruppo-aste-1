package com.project.aste.rest;
import com.project.aste.exception.CustomErrorType;
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
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserAccount>> listAllUsers() {
		List<UserAccount> users = userJpaRepository.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserAccount>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<UserAccount>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserAccount> getUserbyId(@PathVariable("id") final Integer id)
	{
		Optional<UserAccount> user = userJpaRepository.findById(id);
		if (user.isPresent() == false) {
			return new ResponseEntity<UserAccount>(
			new CustomErrorType("L'utente con id "+ id + " non è stato trovato."), HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<UserAccount>(user.get(),HttpStatus.OK);
	}

	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccount> createUser(@Valid @RequestBody final UserAccount user) {
		logger.info("Creating User : {}", user);
		if (userJpaRepository.findByName(user.getName()) != null) {
			logger.error("Utente non creato. L'utente {} è gia presente", user.getName());
			return new ResponseEntity<UserAccount>(
					new CustomErrorType(
							"Utente non creato. L'utente " + user.getName() + " è gia presente."),
					HttpStatus.CONFLICT);
		}
		userJpaRepository.save(user);
		return new ResponseEntity<UserAccount>(user, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccount> updateUser(@PathVariable("id") final Integer id, @RequestBody UserAccount user) {
		// fetch user based on id and set it to currentUser object of type UserDTO
		Optional<UserAccount> optUser = userJpaRepository.findById(id);
		if (optUser.isPresent() == false) {
			return new ResponseEntity<UserAccount>(
					new CustomErrorType("Utente non aggiornato. L'utente con id" + id + " non è stato trovato."), HttpStatus.NOT_FOUND);
		}
		UserAccount currentUser = optUser.get(); 
		currentUser.setName(user.getName());
		currentUser.setEmail(user.getEmail());
		userJpaRepository.saveAndFlush(currentUser);
		return new ResponseEntity<UserAccount>(currentUser, HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<UserAccount> deleteUser(@PathVariable("id") final Integer id) {
		Optional<UserAccount> optUser = userJpaRepository.findById(id);
		if (optUser.isPresent() == false) {
			return new ResponseEntity<UserAccount>(
			new CustomErrorType("Unable to delete. User with id "
			+ id + " not found."), HttpStatus.NOT_FOUND);
			}
		userJpaRepository.deleteById(id);
		return new ResponseEntity<UserAccount>(HttpStatus.NO_CONTENT);
	}
	
}
