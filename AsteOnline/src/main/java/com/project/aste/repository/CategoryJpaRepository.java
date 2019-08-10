package com.project.aste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aste.entity.Category;
@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Integer>{

	public Category findById(int id);
	
	
}
