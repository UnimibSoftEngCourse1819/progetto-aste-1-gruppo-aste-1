package com.project.aste.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Auctions")
public class Auction {

	@Id
	@Column(name = "idAuction")
	private int idAuction;
	
	@Column(name = "state")
	private boolean state;
	
	@Column(name = "numTimeSlot")
	private int numTimeSlot;
	
	@Column(name = "terminationType")
	private boolean terminationType;
	
	@Column(name = "cancellationPenalty")
	private boolean cancellationPenalty;
	
	@Column(name = "timeSlotDuration")
	private LocalDateTime timeSlotDuration;
	
	@Column(name = "startTimeSlot")
	private LocalDateTime startTimeSlot;
	
	@Column(name = "endTimeSlot")
	private LocalDateTime endTimeSlot;
	
	@Column(name = "closed")
	private boolean closed;
	
	@Column(name = "idOffer")
	private int idOffer;
	
	@Column(name = "idObjSer")
	private int idObjSer;
	
	@Column(name = "decline")
	private boolean decline;
	
	
	public int getIdAuction() {
		return idAuction;
	}
	public void setIdAuction(int idAuction) {
		this.idAuction = idAuction;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public int getNumTimeSlot() {
		return numTimeSlot;
	}
	public void setNumTimeSlot(int numTimeSlot) {
		this.numTimeSlot = numTimeSlot;
	}
	public boolean isTerminationType() {
		return terminationType;
	}
	public void setTerminationType(boolean terminationType) {
		this.terminationType = terminationType;
	}
	public boolean isCancellationPenalty() {
		return cancellationPenalty;
	}
	public void setCancellationPenalty(boolean cancellationPenalty) {
		this.cancellationPenalty = cancellationPenalty;
	}
	public LocalDateTime getTimeSlotDuration() {
		return timeSlotDuration;
	}
	public void setTimeSlotDuration(LocalDateTime timeSlotDuration) {
		this.timeSlotDuration = timeSlotDuration;
	}
	public LocalDateTime getStartTimeSlot() {
		return startTimeSlot;
	}
	public void setStartTimeSlot(LocalDateTime startTimeSlot) {
		this.startTimeSlot = startTimeSlot;
	}
	public LocalDateTime getEndTimeSlot() {
		return endTimeSlot;
	}
	public void setEndTimeSlot(LocalDateTime endTimeSlot) {
		this.endTimeSlot = endTimeSlot;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public int getIdOffer() {
		return idOffer;
	}
	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}
	public int getIdObjSer() {
		return idObjSer;
	}
	public void setIdObjSer(int idObjSer) {
		this.idObjSer = idObjSer;
	}
	public boolean isDecline() {
		return decline;
	}
	public void setDecline(boolean decline) {
		this.decline = decline;
	}
	
	
	
	
}
