package com.project.aste.rest;

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

import com.project.aste.entity.AuthenticationData;
import com.project.aste.exception.AuthenticationDataErrorType;
import com.project.aste.repository.AuthenticationDataJpaRepository;


@RestController
@RequestMapping("/authentication")
public class AuthenticationDataRestController {

	public static final Logger logger = LoggerFactory.getLogger(AuthenticationDataRestController.class);
	private AuthenticationDataJpaRepository authenticationDataJpaRepository;

	@Autowired
	public void setAuthenticationDataJpaRepository(AuthenticationDataJpaRepository authenticationDataJpaRepository) {
		this.authenticationDataJpaRepository = authenticationDataJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AuthenticationData>> listAllAuthenticationData() {
		List<AuthenticationData> authenticationData = authenticationDataJpaRepository.findAll();
		if (authenticationData.isEmpty()) {
			return new ResponseEntity<List<AuthenticationData>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<AuthenticationData>>(authenticationData, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuthenticationData> getAuthenticationDatabyId(@PathVariable("id") final Integer idAuthenticationData)
	{
		Optional<AuthenticationData> authenticationData = authenticationDataJpaRepository.findById(idAuthenticationData);
		if (authenticationData.isPresent() == false) {
			return new ResponseEntity<AuthenticationData>(
			new AuthenticationDataErrorType("L'utente con id "+ idAuthenticationData + " non è stata trovata."), HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<AuthenticationData>(authenticationData.get(),HttpStatus.OK);
	}

	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticationData> createAuthenticationData(@Valid @RequestBody final AuthenticationData authenticationData) {
		logger.info("Creando l'autenticazione dell'utente : {}", authenticationData);
		if (authenticationDataJpaRepository.findById(authenticationData.getIdAuthentication()) != null) {
			logger.error("Utente non creato. L'utente {} è gia presente", authenticationData.getIdAuthentication());
			return new ResponseEntity<AuthenticationData>(
					new AuthenticationDataErrorType(
							"Utente non creato. L'utente " + authenticationData.getIdAuthentication() + " è gia presente."),
					HttpStatus.CONFLICT);
		}
		authenticationDataJpaRepository.save(authenticationData);
		return new ResponseEntity<AuthenticationData>(authenticationData, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticationData> updateAuthenticationData(@PathVariable("id") final Integer idAuthenticationData, @RequestBody AuthenticationData authenticationData) {

		Optional<AuthenticationData> optAuthenticationData = authenticationDataJpaRepository.findById(idAuthenticationData);
		if (optAuthenticationData.isPresent() == false) {
			return new ResponseEntity<AuthenticationData>(
					new AuthenticationDataErrorType("Utente non aggiornato. L'utente con id " + idAuthenticationData + " non è stato trovato."), HttpStatus.NOT_FOUND);
		}
		AuthenticationData currentAuthenticationData = optAuthenticationData.get(); 

		
		currentAuthenticationData.setIdAuthentication(authenticationData.getIdAuthentication());
		currentAuthenticationData.setIdRole(authenticationData.getIdRole());
		currentAuthenticationData.setPassword(authenticationData.getPassword());
		currentAuthenticationData.setRegistrationDatetime(authenticationData.getRegistrationDatetime());
		currentAuthenticationData.setUsername(authenticationData.getUsername());
		
		authenticationDataJpaRepository.saveAndFlush(currentAuthenticationData);
		return new ResponseEntity<AuthenticationData>(currentAuthenticationData, HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<AuthenticationData> deleteAuthenticationData(@PathVariable("id") final Integer id) {
		Optional<AuthenticationData> optUser = authenticationDataJpaRepository.findById(id);
		if (optUser.isPresent() == false) {
			return new ResponseEntity<AuthenticationData>(
			new AuthenticationDataErrorType("Indirizzo non cancellato. L'indirizzo con id "
			+ id + " non è stato trovato."), HttpStatus.NOT_FOUND);
			}
		authenticationDataJpaRepository.deleteById(id);
		return new ResponseEntity<AuthenticationData>(HttpStatus.NO_CONTENT);
	}
	
	
}
