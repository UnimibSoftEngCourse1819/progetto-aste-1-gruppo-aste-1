package com.project.aste.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aste.entity.AttributeCategoryMap;


@Repository
public interface AttributeCategoryMapJpaRepository extends JpaRepository<AttributeCategoryMap, Integer>{

	public AttributeCategoryMapJpaRepository findById(int idAttributeCategoryMap);
}