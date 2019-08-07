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

import com.project.aste.entity.Attribute;
import com.project.aste.exception.AttributeErrorType;
import com.project.aste.repository.AttributeJpaRepository;




@RestController
@RequestMapping("/attribute")
public class AttributeRestController {

	public static final Logger logger = LoggerFactory.getLogger(AttributeRestController.class);
	private AttributeJpaRepository attributeJpaRepository;

	@Autowired
	public void setAttributeJpaRepository(AttributeJpaRepository attributeJpaRepository) {
		this.attributeJpaRepository = attributeJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Attribute>> listAllUsers() {
		List<Attribute> attribute = attributeJpaRepository.findAll();
		if (attribute.isEmpty()) {
			return new ResponseEntity<List<Attribute>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Attribute>>(attribute, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Attribute> getUserbyId(@PathVariable("id") final Integer id)
	{
		Optional<Attribute> attribute = attributeJpaRepository.findById(id);
		if (attribute.isPresent() == false) {
			return new ResponseEntity<Attribute>(
			new AttributeErrorType("Attributo  con id "+ id + " non è stato trovato."), HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<Attribute>(attribute.get(),HttpStatus.OK);
	}

	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Attribute> createUser(@Valid @RequestBody final Attribute attribute) {
		logger.info("Creating User : {}", attribute);
		if (attributeJpaRepository.findById(attribute.getIdAttribute()) != null) {
			logger.error("Attributo non inserito. L'attributo  {} è gia presente", attribute.getIdAttribute());
			return new ResponseEntity<Attribute>(
					new AttributeErrorType(
							"Attributo non inserito. L'attributo " + attribute.getIdAttribute() + " è già presente."),
					HttpStatus.CONFLICT);
		}
		attributeJpaRepository.save(attribute);
		return new ResponseEntity<Attribute>(attribute, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Attribute> updateUser(@PathVariable("id") final Integer id, @RequestBody Attribute attribute) {
		// fetch attribute based on id and set it to currentUser object of type UserDTO
		Optional<Attribute> optAttribute = attributeJpaRepository.findById(id);
		if (optAttribute.isPresent() == false) {
			return new ResponseEntity<Attribute>(
					new AttributeErrorType("Attributo non aggiornato. L'attributo con id" + id + " non è stato trovato."), HttpStatus.NOT_FOUND);
		}
		Attribute currentAttribute = optAttribute.get(); 
		currentAttribute.setIdAttribute(attribute.getIdAttribute());
		currentAttribute.setName(attribute.getName());
		attributeJpaRepository.saveAndFlush(currentAttribute);
		return new ResponseEntity<Attribute>(currentAttribute, HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Attribute> deleteUser(@PathVariable("id") final Integer id) {
		Optional<Attribute> optUser = attributeJpaRepository.findById(id);
		if (optUser.isPresent() == false) {
			return new ResponseEntity<Attribute>(
			new AttributeErrorType("Impossibile cancellare l'attributo. Attributo con id "
			+ id + " non trovato."), HttpStatus.NOT_FOUND);
			}
		attributeJpaRepository.deleteById(id);
		return new ResponseEntity<Attribute>(HttpStatus.NO_CONTENT);
	}
	
	
}


