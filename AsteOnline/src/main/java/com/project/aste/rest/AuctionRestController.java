package com.project.aste.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.aste.entity.Auction;
import com.project.aste.exception.AuctionErrorType;
import com.project.aste.repository.AuctionJpaRepository;


@RestController
@RequestMapping("/auction")
public class AuctionRestController {

	public static final Logger logger = LoggerFactory.getLogger(AuctionRestController.class);
	private AuctionJpaRepository auctionJpaRepository;

	@Autowired
	public void setAuctionJpaRepository(AuctionJpaRepository auctionJpaRepository) {
		this.auctionJpaRepository = auctionJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Auction>> listAllUsers() {
		List<Auction> auction = auctionJpaRepository.findAll();
		if (auction.isEmpty()) {
			return new ResponseEntity<List<Auction>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Auction>>(auction, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Auction> getUserbyId(@PathVariable("id") final Integer id)
	{
		Optional<Auction> auction = auctionJpaRepository.findById(id);
		if (auction.isPresent() == false) {
			return new ResponseEntity<Auction>(
			new AuctionErrorType("L'asta con id "+ id + " non è stata trovata."), HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<Auction>(auction.get(),HttpStatus.OK);
	}

	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Auction> createUser(@Valid @RequestBody final Auction auction) {
		logger.info("Creating User : {}", auction);
		if (auctionJpaRepository.findById(auction.getIdAuction()) != null) {
			logger.error("Asta non creata. L'asta {} è gia presente", auction.getIdAuction());
			return new ResponseEntity<Auction>(
					new AuctionErrorType(
							"Asta non creata. L'asta " + auction.getIdAuction() + " è gia presente."),
					HttpStatus.CONFLICT);
		}
		auctionJpaRepository.save(auction);
		return new ResponseEntity<Auction>(auction, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Auction> updateUser(@PathVariable("id") final Integer id, @RequestBody Auction auction) {
		// fetch auction based on id and set it to currentUser object of type UserDTO
		Optional<Auction> optAuction = auctionJpaRepository.findById(id);
		if (optAuction.isPresent() == false) {
			return new ResponseEntity<Auction>(
					new AuctionErrorType("Asta non aggiornata. L'asta con id" + id + " non è stata trovata."), HttpStatus.NOT_FOUND);
		}
		Auction currentAuction = optAuction.get(); 
		currentAuction.setIdObjSer(auction.getIdObjSer());
		currentAuction.setNumTimeSlot(auction.getNumTimeSlot());
		currentAuction.setStartTimeSlot(auction.getStartTimeSlot());
		currentAuction.setTimeSlotDuration(auction.getTimeSlotDuration());
		currentAuction.setCancellationPenalty(auction.isCancellationPenalty());
		currentAuction.setClosedEnvelop(auction.isClosedEnvelop());
		currentAuction.setDecline(auction.isDecline());
		currentAuction.setState(auction.isState());
		currentAuction.setTerminationType(auction.isTerminationType());
		currentAuction.setWinner(auction.getWinner());
		auctionJpaRepository.saveAndFlush(currentAuction);
		return new ResponseEntity<Auction>(currentAuction, HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Auction> deleteUser(@PathVariable("id") final Integer id) {
		Optional<Auction> optUser = auctionJpaRepository.findById(id);
		if (optUser.isPresent() == false) {
			return new ResponseEntity<Auction>(
			new AuctionErrorType("Unable to delete. Asta with id "
			+ id + " not found."), HttpStatus.NOT_FOUND);
			}
		auctionJpaRepository.deleteById(id);
		return new ResponseEntity<Auction>(HttpStatus.NO_CONTENT);
	}
	
	
}
