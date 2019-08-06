package com.project.aste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.aste.entity.Auction;


@Repository
public interface AuctionJpaRepository extends JpaRepository<Auction, Integer> {
	 Auction findById(int idAuction);
}
