package com.project.aste.repository;
//

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.aste.entity.AuthenticationData;

@Repository
public interface UserJpaRepository extends JpaRepository<AuthenticationData, Integer> {
	AuthenticationData findByName(String name);
}

