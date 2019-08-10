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

import com.project.aste.entity.Category;
import com.project.aste.exception.CategoryErrorType;
import com.project.aste.repository.CategoryJpaRepository;
import com.project.aste.repository.CategoryJpaRepository;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {
	
	

	public static final Logger logger = LoggerFactory.getLogger(CategoryRestController.class);
	private CategoryJpaRepository categoryJpaRepository;

	@Autowired
	public void setCategoryJpaRepository(CategoryJpaRepository categoryJpaRepository) {
		this.categoryJpaRepository = categoryJpaRepository;
	}
	@GetMapping("/")
	public ResponseEntity<List<Category>> listAllCategories() {
		List<Category> category = categoryJpaRepository.findAll();
		if (category.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategorybyId(@PathVariable("id") final Integer id)
	{
		Optional<Category> category = categoryJpaRepository.findById(id);
		if (category.isPresent() == false) {
			return new ResponseEntity<Category>(
			new CategoryErrorType("La categoria con id "+ id + " non è stata trovata."), HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<Category>(category.get(),HttpStatus.OK);
	}

	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createCategory(@Valid @RequestBody final Category category) {
		logger.info("Creating category : {}", category);
		if (categoryJpaRepository.findById(category.getIdCategory()) != null)
				{
			logger.error("Categoria non creata. La categoria {} è gia presente", category.getIdCategory());
			return new ResponseEntity<Category>(
					new CategoryErrorType(
							"Categoria non creata. La categoria " + category.getIdCategory() + " è gia presente."),
					HttpStatus.CONFLICT);
		}
		categoryJpaRepository.save(category);
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> updateCategory(@PathVariable("id") final Integer id, @RequestBody Category category) {
		Optional<Category> optCategory = categoryJpaRepository.findById(id);
		if (optCategory.isPresent() == false) {
			return new ResponseEntity<Category>(
					new CategoryErrorType("Categoria non aggiornata. La categoria con id" + id + " non è stata trovata."), HttpStatus.NOT_FOUND);
		}
		Category currentCategory = optCategory.get(); 
		currentCategory.setIdCategory(category.getIdCategory());
		currentCategory.setName(category.getName());
		categoryJpaRepository.saveAndFlush(currentCategory);
		return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteUser(@PathVariable("id") final Integer id) {
		Optional<Category> optUser = categoryJpaRepository.findById(id);
		if (optUser.isPresent() == false) {
			return new ResponseEntity<Category>(
			new CategoryErrorType("Non è possibile cancellare la categoria. Categoria con id id "
			+ id + " non trovata."), HttpStatus.NOT_FOUND);
			}
		categoryJpaRepository.deleteById(id);
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
	}
	
	

}
