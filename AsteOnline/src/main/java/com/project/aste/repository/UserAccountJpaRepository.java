package com.project.aste.repository;

import org.springframework.stereotype.Repository;

import com.project.aste.entity.UserAccount;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserAccountJpaRepository extends JpaRepository<UserAccount,Integer> {

	public UserAccount findByName(String name);
}
