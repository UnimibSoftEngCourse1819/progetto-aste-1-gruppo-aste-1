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

import com.project.aste.entity.AttributeCategoryMap;
import com.project.aste.entity.Auction;
import com.project.aste.exception.AttributeCategoryMapErrorType;
import com.project.aste.repository.AttributeCategoryMapJpaRepository;
import com.project.aste.repository.UserAccountJpaRepository;



@RestController
@RequestMapping("/attributeCategoryMap")
public class AttributeCategoryMapRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(AttributeCategoryMapRestController.class);
	private AttributeCategoryMapJpaRepository acmJpaRepository;

	@Autowired
	public void setAttributeCategoryMapJpaRepository(AttributeCategoryMapJpaRepository acmJpaRepository) {
		this.acmJpaRepository = acmJpaRepository;
	}
//	@GetMapping("/")
//	public ResponseEntity<List<AttributeCategoryMap>> listAllACM() {
//		List<AttributeCategoryMap> acm = acmJpaRepository.findAll();
//		if (acm.isEmpty()) {
//			return new ResponseEntity<List<AttributeCategoryMap>>(HttpStatus.NO_CONTENT);
//			}
//		return new ResponseEntity<List<AttributeCategoryMap>>(acm, HttpStatus.OK);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<AttributeCategoryMap> getUserbyId(@PathVariable("id") final Integer id)
//	{
//		Optional<AttributeCategoryMap> attributeCategoryMap = acmJpaRepository.findById(id);
//		if (attributeCategoryMap.isPresent() == false) {
//			return new ResponseEntity<AttributeCategoryMap>(
//			new AttributeCategoryMapErrorType("L'asta con id "+ id + " non è stata trovata."), HttpStatus.NOT_FOUND);
//			}
//		return new ResponseEntity<AttributeCategoryMap>(attributeCategoryMap.get(),HttpStatus.OK);
//	}
//
//	
//	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AttributeCategoryMap> createUser(@Valid @RequestBody final AttributeCategoryMap attributeCategoryMap) {
//		logger.info("Creating User : {}", attributeCategoryMap);
//		if (attributeCategoryMapJpaRepository.findById(attributeCategoryMap.getIdAttributeCategoryMap()) != null) {
//			logger.error("Asta non creata. L'asta {} è gia presente", attributeCategoryMap.getIdAttributeCategoryMap());
//			return new ResponseEntity<AttributeCategoryMap>(
//					new AttributeCategoryMapErrorType(
//							"Asta non creata. L'asta " + attributeCategoryMap.getIdAttributeCategoryMap() + " è gia presente."),
//					HttpStatus.CONFLICT);
//		}
//		attributeCategoryMapJpaRepository.save(attributeCategoryMap);
//		return new ResponseEntity<AttributeCategoryMap>(attributeCategoryMap, HttpStatus.CREATED);
//	}
//	
//	
//	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<AttributeCategoryMap> updateUser(@PathVariable("id") final Integer id, @RequestBody AttributeCategoryMap attributeCategoryMap) {
//		// fetch attributeCategoryMap based on id and set it to currentUser object of type UserDTO
//		Optional<AttributeCategoryMap> optAttributeCategoryMap = attributeCategoryMapJpaRepository.findById(id);
//		if (optAttributeCategoryMap.isPresent() == false) {
//			return new ResponseEntity<AttributeCategoryMap>(
//					new AttributeCategoryMapErrorType("Asta non aggiornata. L'asta con id" + id + " non è stata trovata."), HttpStatus.NOT_FOUND);
//		}
//		AttributeCategoryMap currentAttributeCategoryMap = optAttributeCategoryMap.get(); 
//		currentAttributeCategoryMap.setIdCategory(attributeCategoryMap.getIdCategory());
//		currentAttributeCategoryMap.setIdAttribute(attributeCategoryMap.getIdAttribute());
//		attributeCategoryMapJpaRepository.saveAndFlush(currentAttributeCategoryMap);
//		return new ResponseEntity<AttributeCategoryMap>(currentAttributeCategoryMap, HttpStatus.OK);
//	}
//	
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<AttributeCategoryMap> deleteUser(@PathVariable("id") final Integer id) {
//		Optional<AttributeCategoryMap> optUser = attributeCategoryMapJpaRepository.findById(id);
//		if (optUser.isPresent() == false) {
//			return new ResponseEntity<AttributeCategoryMap>(
//			new AttributeCategoryMapErrorType("Unable to delete. Asta with id "
//			+ id + " not found."), HttpStatus.NOT_FOUND);
//			}
//		attributeCategoryMapJpaRepository.deleteById(id);
//		return new ResponseEntity<AttributeCategoryMap>(HttpStatus.NO_CONTENT);
//	}
//	
//	
}
