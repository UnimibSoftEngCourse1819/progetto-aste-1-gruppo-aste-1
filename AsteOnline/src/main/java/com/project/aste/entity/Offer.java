package com.project.aste.entity;

public class Offer {

	private int idOffer;
	private String amountOffers;
	private int idOfferent;
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
