package com.project.aste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aste.entity.Attribute;


@Repository
public interface AttributeJpaRepository extends JpaRepository<Attribute, Integer>{

	public Attribute findById(int idAttributeJpaRepository);
}
