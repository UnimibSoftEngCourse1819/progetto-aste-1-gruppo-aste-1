package com.project.aste.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.aste.entity.Role;
import com.project.aste.exception.RoleErrorType;
import com.project.aste.repository.RoleJpaRepository;



@RestController
@RequestMapping("/role")
public class RoleRestController {

	public static final Logger logger = LoggerFactory.getLogger(RoleRestController.class);
	private RoleJpaRepository roleJpaRepository;

	@Autowired
	public void setRoleJpaRepository(RoleJpaRepository roleJpaRepository) {
		this.roleJpaRepository = roleJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Role>> listAllRole() {
		List<Role> role = roleJpaRepository.findAll();
		if (role.isEmpty()) {
			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Role>>(role, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> getRolebyId(@PathVariable("id") final Integer id)
	{
		Optional<Role> role = roleJpaRepository.findById(id);
		if (role.isPresent() == false) {
			return new ResponseEntity<Role>(
			new RoleErrorType("Ruolo con id "+ id + " non trovato."), HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<Role>(role.get(),HttpStatus.OK);
	}
	
	
	
}
