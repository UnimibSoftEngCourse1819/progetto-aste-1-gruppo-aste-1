package com.project.aste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aste.entity.ObjectService;

@Repository
public interface ObjectServiceJpaRepository extends JpaRepository<ObjectService, Integer> {
	
	public ObjectService findById(int idObjSer);
}




