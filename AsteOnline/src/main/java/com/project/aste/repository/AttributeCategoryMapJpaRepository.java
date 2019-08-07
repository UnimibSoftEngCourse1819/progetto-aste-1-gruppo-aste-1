package com.project.aste.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttributeCategoryMapJpaRepository extends JpaRepository<AttributeCategoryMapJpaRepository, Integer>{

	AttributeCategoryMapJpaRepository findById(int idAttributeCategoryMap);
}