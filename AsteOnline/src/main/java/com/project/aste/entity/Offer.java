package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Offer")
public class Offer {

	@Id
	@Column(name="idOffer")
	private int idOffer;
	
	@Column(name="amountOffers")
	private String amountOffers;
	
	@Column(name="idOfferent")
	private int idOfferent;
	
	@Column(name="idAuction")
	private int idAuction;
	
	
	public Offer(int idOffer, String amountOffers, int idOfferent, int idAuction) {
		super();
		this.idOffer = idOffer;
		this.amountOffers = amountOffers;
		this.idOfferent = idOfferent;
		this.idAuction = idAuction;
	}


	public int getIdOffer() {
		return idOffer;
	}


	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}


	public String getAmountOffers() {
		return amountOffers;
	}


	public void setAmountOffers(String amountOffers) {
		this.amountOffers = amountOffers;
	}


	public int getIdOfferent() {
		return idOfferent;
	}


	public void setIdOfferent(int idOfferent) {
		this.idOfferent = idOfferent;
	}


	public int getIdAuction() {
		return idAuction;
	}


	public void setIdAuction(int idAuction) {
		this.idAuction = idAuction;
	}
	
	
	
	
}
