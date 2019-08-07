package com.project.aste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aste.entity.Address;
import com.project.aste.entity.Auction;


@Repository
public interface AddressJpaRepository extends JpaRepository<Address, Integer> {
	Address findById(int idAddress);
}
