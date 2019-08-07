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

import com.project.aste.entity.Address;
import com.project.aste.exception.AddressErrorType;
import com.project.aste.repository.AddressJpaRepository;


@RestController
@RequestMapping("/address")
public class AddressRestController {

	public static final Logger logger = LoggerFactory.getLogger(AddressRestController.class);
	private AddressJpaRepository addressJpaRepository;

	@Autowired
	public void setAddressJpaRepository(AddressJpaRepository addressJpaRepository) {
		this.addressJpaRepository = addressJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Address>> listAllAddress() {
		List<Address> address = addressJpaRepository.findAll();
		if (address.isEmpty()) {
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> getUserbyId(@PathVariable("id") final Integer idAddress)
	{
		Optional<Address> address = addressJpaRepository.findById(idAddress);
		if (address.isPresent() == false) {
			return new ResponseEntity<Address>(
			new AddressErrorType("L'indirizzo con id "+ idAddress + " non è stata trovata."), HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<Address>(address.get(),HttpStatus.OK);
	}

	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> createAddress(@Valid @RequestBody final Address address) {
		logger.info("Creando l'indirizzo : {}", address);
		if (addressJpaRepository.findById(address.getIdAddress()) != null) {
			logger.error("Indirizzo non creato. L'indirizzo {} è gia presente", address.getIdAddress());
			return new ResponseEntity<Address>(
					new AddressErrorType(
							"Indirizzo non creata. L'indirizzo " + address.getIdAddress() + " è gia presente."),
					HttpStatus.CONFLICT);
		}
		addressJpaRepository.save(address);
		return new ResponseEntity<Address>(address, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> updateAddress(@PathVariable("id") final Integer idAddress, @RequestBody Address address) {

		Optional<Address> optAddress = addressJpaRepository.findById(idAddress);
		if (optAddress.isPresent() == false) {
			return new ResponseEntity<Address>(
					new AddressErrorType("Indirizzo non aggiornata. L'indirizzo con id " + idAddress + " non è stata trovata."), HttpStatus.NOT_FOUND);
		}
		Address currentAddress = optAddress.get(); 

		currentAddress.setIdAddress(address.getIdAddress());
		currentAddress.setNation(address.getNation());
		currentAddress.setCity(address.getCity());
		currentAddress.setPostalCode(address.getPostalCode());
		currentAddress.setPostalCode(address.getPostalCode());
		currentAddress.setProvince(address.getProvince());
		currentAddress.setStreet(address.getStreet());
		currentAddress.setHouseNumber(address.getHouseNumber());
		addressJpaRepository.saveAndFlush(currentAddress);
		return new ResponseEntity<Address>(currentAddress, HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Address> deleteUser(@PathVariable("id") final Integer id) {
		Optional<Address> optUser = addressJpaRepository.findById(id);
		if (optUser.isPresent() == false) {
			return new ResponseEntity<Address>(
			new AddressErrorType("Indirizzo non cancellato. L'indirizzo con id "
			+ id + " non è stato trovato."), HttpStatus.NOT_FOUND);
			}
		addressJpaRepository.deleteById(id);
		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}
	
	
}
