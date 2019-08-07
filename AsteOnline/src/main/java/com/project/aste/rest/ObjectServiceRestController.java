package com.project.aste.rest;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

import com.project.aste.entity.ObjectService;
import com.project.aste.exception.ObjectServiceErrorType;
import com.project.aste.repository.AttributeCategoryMapJpaRepository;
import com.project.aste.repository.ObjectServiceJpaRepository;



@RestController
@RequestMapping("/objectservice")
public class ObjectServiceRestController {
	public static final Logger logger = LoggerFactory.getLogger(ObjectServiceRestController.class);
	private ObjectServiceJpaRepository objJpaRepository;


	@Autowired
	public void setObjectServiceJpaRepository(ObjectServiceJpaRepository objJpaRepository) {
		this.objJpaRepository = objJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ObjectService>> listAllUsers() {
		List<ObjectService> obj = objJpaRepository.findAll();
		if (obj.isEmpty()) {
			return new ResponseEntity<List<ObjectService>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<ObjectService>>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ObjectService> getUserbyId(@PathVariable("id") final Integer id)
	{
		Optional<ObjectService> obj = objJpaRepository.findById(id);
		if (obj.isPresent() == false) {
			return new ResponseEntity<ObjectService>(
			new ObjectServiceErrorType("L'oggetto con id "+ id + " non è stato trovato."), HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<ObjectService>(obj.get(),HttpStatus.OK);
	}

	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ObjectService> createUser(@Valid @RequestBody final ObjectService obj) {
		logger.info("Creating User : {}", obj);
		if (objJpaRepository.findById(obj.getIdObjSer()) != null) {
			logger.error("Utente non creato. L'utente {} è gia presente", obj.getName());
			return new ResponseEntity<ObjectService>(
					new ObjectServiceErrorType(
							"Utente non creato. L'utente " + obj.getName() + " è gia presente."),
					HttpStatus.CONFLICT);
		}
		objJpaRepository.save(obj);
		return new ResponseEntity<ObjectService>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ObjectService> updateUser(@PathVariable("id") final Integer id, @RequestBody ObjectService obj) {
		// fetch obj based on id and set it to currentUser object of type UserDTO
		Optional<ObjectService> optObj = objJpaRepository.findById(id);
		if (optObj.isPresent() == false) {
			return new ResponseEntity<ObjectService>(
					new ObjectServiceErrorType("Oggetto non aggiornato. L'oggetto con id" + id + " non è stato trovato."), HttpStatus.NOT_FOUND);
		}
		ObjectService currentObj = optObj.get(); 
		currentObj.setName(obj.getName());
		currentObj.setDescription(obj.getDescription());
		currentObj.setStartPrice(obj.getStartPrice());
		currentObj.setIdObject(obj.isIdObject());
		currentObj.setAvailable(obj.isAvailable());
		currentObj.setIdCategory(obj.getIdCategory());
		currentObj.setIdUser(obj.getIdUser());
		currentObj.setIdAddress(obj.getIdAddress());
		objJpaRepository.saveAndFlush(currentObj);
		return new ResponseEntity<ObjectService>(currentObj, HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<ObjectService> deleteUser(@PathVariable("id") final Integer id) {
		Optional<ObjectService> optUser = objJpaRepository.findById(id);
		if (optUser.isPresent() == false) {
			return new ResponseEntity<ObjectService>(
			new ObjectServiceErrorType("Impossibile cancellare l'oggetto o servizio. L'elemento con id "
			+ id + " non è stato trovato."), HttpStatus.NOT_FOUND);
			}
		objJpaRepository.deleteById(id);
		return new ResponseEntity<ObjectService>(HttpStatus.NO_CONTENT);
	}
	
}
