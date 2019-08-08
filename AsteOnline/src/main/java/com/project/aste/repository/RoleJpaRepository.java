package com.project.aste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aste.entity.Role;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Integer> {
	Role findById(int idAddress);
}



