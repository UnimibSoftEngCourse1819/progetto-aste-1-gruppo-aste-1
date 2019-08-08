package com.project.aste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aste.entity.AuthenticationData;


@Repository
public interface AuthenticationDataJpaRepository extends JpaRepository<AuthenticationData, Integer> {
	public AuthenticationData findByUsername(String username);
}
